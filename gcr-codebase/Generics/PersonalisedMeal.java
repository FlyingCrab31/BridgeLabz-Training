
import java.lang.reflect.InvocationTargetException;

interface MealPlan {

    String getName();

    int getCaloriesPerDay();

    boolean isValidForGoal(String goal); // e.g. weight_loss, muscle_gain
}

class VegetarianMeal implements MealPlan {

    @Override
    public String getName() {
        return "Vegetarian";
    }

    @Override
    public int getCaloriesPerDay() {
        return 2000;
    }

    @Override
    public boolean isValidForGoal(String goal) {
        return goal.equalsIgnoreCase("weight_loss")
                || goal.equalsIgnoreCase("maintenance");
    }
}

class VeganMeal implements MealPlan {

    @Override
    public String getName() {
        return "Vegan";
    }

    @Override
    public int getCaloriesPerDay() {
        return 1900;
    }

    @Override
    public boolean isValidForGoal(String goal) {
        return true; // assume ok for all goals
    }
}

class KetoMeal implements MealPlan {

    @Override
    public String getName() {
        return "Keto";
    }

    @Override
    public int getCaloriesPerDay() {
        return 1800;
    }

    @Override
    public boolean isValidForGoal(String goal) {
        return goal.equalsIgnoreCase("weight_loss");
    }
}

class HighProteinMeal implements MealPlan {

    @Override
    public String getName() {
        return "High-Protein";
    }

    @Override
    public int getCaloriesPerDay() {
        return 2200;
    }

    @Override
    public boolean isValidForGoal(String goal) {
        return goal.equalsIgnoreCase("muscle_gain");
    }
}

class Meal<T extends MealPlan> {

    private final T plan;
    private final String userName;
    private final String goal; // e.g. weight_loss, muscle_gain

    public Meal(T plan, String userName, String goal) {
        this.plan = plan;
        this.userName = userName;
        this.goal = goal;
    }

    public T getPlan() {
        return plan;
    }

    public String getUserName() {
        return userName;
    }

    public String getGoal() {
        return goal;
    }

    @Override
    public String toString() {
        return "Meal for " + userName
                + " -> " + plan.getName()
                + " (" + plan.getCaloriesPerDay() + " kcal, goal: " + goal + ")";
    }
}

class MealPlanGenerator {

    // Generic factory method with bounded type parameter
    public static <T extends MealPlan> Meal<T> generateMealPlan(
            Class<T> type,
            String userName,
            String goal) {

        T plan = createPlanInstance(type);

        if (!plan.isValidForGoal(goal)) {
            throw new IllegalArgumentException(
                    "Selected meal type " + plan.getName()
                    + " is not valid for goal: " + goal);
        }

        return new Meal<>(plan, userName, goal);
    }

    // Helper to create correct plan instance based on Class<T>
    private static <T extends MealPlan> T createPlanInstance(Class<T> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Cannot create meal plan instance", e);
        }
    }
}

public class PersonalisedMeal {

    public static void main(String[] args) {
        // user 1 wants weight loss with vegetarian
        Meal<VegetarianMeal> m1
                = MealPlanGenerator.generateMealPlan(
                        VegetarianMeal.class,
                        "Amit",
                        "weight_loss");

        // user 2 wants muscle gain with high-protein
        Meal<HighProteinMeal> m2
                = MealPlanGenerator.generateMealPlan(
                        HighProteinMeal.class,
                        "Sara",
                        "muscle_gain");

        System.out.println(m1);
        System.out.println(m2);

        // This will throw IllegalArgumentException if not valid:
        // Meal<KetoMeal> bad =
        //    MealPlanGenerator.generateMealPlan(KetoMeal.class, "John", "muscle_gain");
    }
}
