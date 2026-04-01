public class JsonMain{
    public static void main(String[] args) {
        User user = new User("Anushka ", "a@gmail.com", "anushka3456123");
        String jsonString = JsonSerialization.toJson(user);
        System.out.println(jsonString);
    }

}