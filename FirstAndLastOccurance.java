package BinarySearch;
public class FirstAndLastOccurance {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] sortedArray = { 7, 10, 15, 18, 18, 25, 30, 42 };
        int targetElement = 18;

        int firstOccurrence = findFirstOccurrence(sortedArray, targetElement);
        int lastOccurrence = findLastOccurrence(sortedArray, targetElement);

        System.out.println("First occurrence of " + targetElement + " at index: " + firstOccurrence);
        System.out.println("Last occurrence of " + targetElement + " at index: " + lastOccurrence);
    }
}

