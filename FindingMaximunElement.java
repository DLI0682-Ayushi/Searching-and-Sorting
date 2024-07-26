public class FindingMaximunElement {
    public static int findMaxElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null.");
        }
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        return maxElement;
    }
    public static void main(String[] args) {
        int[] myArray = { 10, 25, 7, 42, 15, 30, 18 };

        int max = findMaxElement(myArray);

        System.out.println("The maximum element in the array is: " + max);
    }
}

