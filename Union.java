package ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class Union {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the first list: ");
        int n1 = scanner.nextInt();
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("Enter elements for the first list:");
        for (int i = 0; i < n1; i++) {
            list1.add(scanner.nextInt());
        }
        System.out.print("Enter the number of elements in the second list: ");
        int n2 = scanner.nextInt();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("Enter elements for the second list:");
        for (int i = 0; i < n2; i++) {
            list2.add(scanner.nextInt());
        }
        HashSet<Integer> unionSet = new HashSet<>(list1);
        unionSet.addAll(list2);
        ArrayList<Integer> unionList = new ArrayList<>(unionSet);
        System.out.println("Union of the lists (including unique elements):");
        for (int num : unionList) {
            System.out.print(num + " ");
        }
    }
}

