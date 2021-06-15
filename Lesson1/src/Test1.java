import com.google.gson.Gson;

public class Test1 {
    public static void main(String[] args) {
        Human human = new Human("Vahe", 1988);
        Gson g = new Gson();
        System.out.println(g.toJson(human));

//        String ss = "{\"name\":\"Vahe\",\"year\":1988}";

        Human h = g.fromJson(g.toJson(human), Human.class);
        System.out.println(h);
    }
}
