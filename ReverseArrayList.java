package ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class ReverseArrayList {
    public static void reverse(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> myList = new ArrayList<>();
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.add(scanner.nextInt());
        }
        ArrayList<Integer> reversedList = new ArrayList<>(myList);
        reverse(reversedList);
        System.out.println("Reversed list:");
        for (int num : reversedList) {
            System.out.print(num + " ");
        }
    }
}
