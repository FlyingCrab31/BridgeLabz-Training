public class AdminService{

    @RoleAllowed("ADMIN")
    public void deleteUser(){
        System.out.println("User deleted successfully");
    }

    public void viewProfile(){
        System.out.println("User profile viewed successfully");
    
    }
}