public class User{
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    @JsonField(name = "user_password")
    private String password;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}