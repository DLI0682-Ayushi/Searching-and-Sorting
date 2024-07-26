package ArrayList;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        ArrayList<Integer> myList = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.add(scanner.nextInt());
        }
        LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>(myList);
        ArrayList<Integer> modifiedList = new ArrayList<>(uniqueElements);
        System.out.println("List with duplicates removed:");
        for (int num : modifiedList) {
            System.out.print(num + " ");
        }
    }
}

