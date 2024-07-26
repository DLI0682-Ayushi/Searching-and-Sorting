import java.util.List;
public class FindingFirstOccurance {
    public static int findFirstOccurrence(List<Integer> numbers, int target) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        List<Integer> myList = List.of(10, 25, 7, 42, 15, 30, 18);
        int targetNumber = 42;
        int index = findFirstOccurrence(myList, targetNumber);
        if (index != -1) {
            System.out.println("Number " + targetNumber + " found at index " + index);
        } else {
            System.out.println("Number " + targetNumber + " not found in the list.");
        }
    }
}
