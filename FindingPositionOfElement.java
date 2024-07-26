package BinarySearch;
public class FindingPositionOfElement {
    public static int findPosition(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArray = { 7, 10, 15, 18, 25, 30, 42 };
        int targetElement = 18;
        int position = findPosition(sortedArray, targetElement);
        if (position != -1) {
            System.out.println("Element " + targetElement + " found at index " + position);
        } else {
            System.out.println("Element " + targetElement + " not found in the array.");
        }
    }
}
