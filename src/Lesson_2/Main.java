import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyLinkedList<>();
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(51);
        myList.add(34);
        myList.remove(1);


        for (int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));
    }
}
