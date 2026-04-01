import java.lang.reflect.Method;

public class RoleMain{

    public static void main(String [] args) throws Exception{

        AdminService adminService = new AdminService();
       
       UserContext.setRole("ADMIN");

       Method[] methods = AdminService.class.getDeclaredMethods();

       for(Method method : methods){
        if(method.isAnnotationPresent(RoleAllowed.class)){
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole= roleAllowed.value();

            if(requiredRole.equals(UserContext.getRole())){
                method.invoke(adminService);
            }
            else{
                System.out.println("Access Denied");
            }
        }
        else{
            method.invoke(adminService);
            }
        }
       }


    }
