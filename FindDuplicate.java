package ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class FindDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        ArrayList<Integer> myList = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.add(scanner.nextInt());
        }
        HashSet<Integer> seenElements = new HashSet<>();
        HashSet<Integer> duplicateElements = new HashSet<>();
        for (int num : myList) {
            if (seenElements.contains(num)) {
                duplicateElements.add(num);
            } else {
                seenElements.add(num);
            }
        }
        if (duplicateElements.isEmpty()) {
            System.out.println("No duplicate elements found.");
        } else {
            System.out.println("Duplicate elements in the list:");
            for (int duplicate : duplicateElements) {
                System.out.println(duplicate);
            }
        }
    }
}

