import java.lang.reflect.Field;

public class User{

    @MaxLength(10)

    private String username;

    public User(String username){
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username){
        try{
            Field field=this.getClass().getDeclaredField("username");
           // MaxLength maxLength=field.getAnnotation(MaxLength.class);

           if(field.isAnnotationPresent(MaxLength.class)){
            MaxLength maxLength = field.getAnnotation(MaxLength.class);
           int limit=maxLength.value();
           
           if(username !=null && username.length()>limit){
            throw new IllegalArgumentException(
                "Username length exceeds max allowed length "+limit
            );
           }

        }


    }catch(NoSuchFieldException e){
        e.printStackTrace();
    }
}

public String getUsername(){
    return username;
}

    }
