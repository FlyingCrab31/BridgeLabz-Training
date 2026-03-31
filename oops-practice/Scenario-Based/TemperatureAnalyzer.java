public class TemperatureAnalyzer {

    public static void main(String[] args) {
        // 7 days, 24 hours
        float[][] temps = new float[7][24];

        // Fill with some sample data (for checking)
        for (int d = 0; d < temps.length; d++) {
            for (int h = 0; h < temps[d].length; h++) {
                temps[d][h] = 20 + d + h * 0.1f; // sample data
            }
        }

        // Call the analysis method
        TemperatureStats stats = analyzeWeek(temps);

        // Optional: day names
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.println("Hottest day: " + dayNames[stats.getHottestDay()]
                + " (index " + stats.getHottestDay() + ")");
        System.out.println("Coldest day: " + dayNames[stats.getColdestDay()]
                + " (index " + stats.getColdestDay() + ")");

        System.out.println("\nAverage temperature per day:");
        float[] averages = stats.getDailyAverages();
        for (int d = 0; d < averages.length; d++) {
            System.out.println(dayNames[d] + ": " + averages[d]);
        }
    }

    // Pure logic method
    public static TemperatureStats analyzeWeek(float[][] temps) {
        int days = temps.length;          // should be 7
        int hours = temps[0].length;      // should be 24

        float globalMax = Float.NEGATIVE_INFINITY;
        float globalMin = Float.POSITIVE_INFINITY;
        int hottestDay = -1;
        int coldestDay = -1;

        float[] dailyAverages = new float[days];

        for (int d = 0; d < days; d++) {
            float sum = 0;

            for (int h = 0; h < hours; h++) {
                float t = temps[d][h];
                sum += t;

                if (t > globalMax) {
                    globalMax = t;
                    hottestDay = d;
                }
                if (t < globalMin) {
                    globalMin = t;
                    coldestDay = d;
                }
            }

            dailyAverages[d] = sum / hours; // average for day d
        }

        return new TemperatureStats(hottestDay, coldestDay, dailyAverages);
    }
}

// Simple data holder with getters
class TemperatureStats {
    private int hottestDay;      // 0..6
    private int coldestDay;      // 0..6
    private float[] dailyAverages; // length 7

    public TemperatureStats(int hottestDay, int coldestDay, float[] dailyAverages) {
        this.hottestDay = hottestDay;
        this.coldestDay = coldestDay;
        this.dailyAverages = dailyAverages;
    }

    public int getHottestDay() {
        return hottestDay;
    }

    public int getColdestDay() {
        return coldestDay;
    }

    public float[] getDailyAverages() {
        return dailyAverages;
    }
}
