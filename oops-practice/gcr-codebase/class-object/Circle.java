public class Circle{
    
    int radius;
    Circle(int radius){
        this.radius = radius;
    }
    public double calculateArea(){
        double rad = Math.PI * radius * radius;
        return rad;
    }
    public double calculateCircum(){
        double circum = 2 * Math.PI * radius;
        return circum;
    }
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Area of Circle :" + circle.calculateArea());
        System.out.println("Circumference of Circle :" + circle.calculateCircum());
    }
}