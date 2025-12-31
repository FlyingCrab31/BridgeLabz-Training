class Circle {
    // Attribute
    double radius;

    // Default constructor (no-arg)
    Circle() {
        // Call parameterized constructor with default value
        this(1.0);   // default radius
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to display radius
    void displayRadius() {
        System.out.println("Radius of circle: " + radius);
    }

    // Test the constructors
    public static void main(String[] args) {
        Circle defaultCircle = new Circle();      // uses default radius 1.0
        defaultCircle.displayRadius();

        Circle userCircle = new Circle(5.5);      // uses user-provided radius
        userCircle.displayRadius();
    }
}
