public class ExceptionPropogation{

    static void method1(){
        int result = 10/0;
    }

    static void method2(){
        method1();
    }


    public static void main(String args[]){
        try{

            method2();
        }

        catch(ArithmeticException e){
            System.out.println("Handeled exception in main");
        }
    }
}