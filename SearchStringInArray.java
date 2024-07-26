import java.util.Scanner;
public class SearchStringInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringArray = { "apple", "banana", "cherry", "date", "fig", "grape" };
        System.out.print("Enter the string to search for: ");
        String target = scanner.nextLine();
        int index = linearSearch(stringArray, target);
        if (index != -1) {
            System.out.println("String \"" + target + "\" found at index " + index);
        } else {
            System.out.println("String \"" + target + "\" not found in the array.");
        }
    }
    public static int linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
