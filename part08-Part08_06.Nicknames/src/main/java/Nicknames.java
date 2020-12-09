
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("matt", "matthew");
        hashMap.put("mix", "michael");
        hashMap.put("artie", "arthur");
        System.out.println(hashMap.get("matt"));
    }
}
