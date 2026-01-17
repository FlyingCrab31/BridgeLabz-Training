
public class ConcatenateString {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};
        for (String word : words) {
            sb.append(word);
        }
        System.out.println(sb.toString());
    }

}
