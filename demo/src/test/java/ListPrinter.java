import java.util.List;

public class ListPrinter
{
    public static void printList(List<Integer> list) {

        if(list == null){
            return;
        }

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));

            // Add a comma and space after each element, except the last one
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
