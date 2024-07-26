package BinarySearch;
public class SmallestAndLargest {
    public static int findSmallestGreaterOrEqual(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static int findLargestSmallerOrEqual(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Initialize result to -1 (not found)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] sortedArray = { 7, 10, 15, 18, 25, 30, 42 };
        int targetValue = 20;
        int smallestGreaterOrEqual = findSmallestGreaterOrEqual(sortedArray, targetValue);
        int largestSmallerOrEqual = findLargestSmallerOrEqual(sortedArray, targetValue);
        System.out.println("Smallest element greater than or equal to " + targetValue +
                " found at index: " + smallestGreaterOrEqual);
        System.out.println("Largest element smaller than or equal to " + targetValue +
                " found at index: " + largestSmallerOrEqual);
    }
}

