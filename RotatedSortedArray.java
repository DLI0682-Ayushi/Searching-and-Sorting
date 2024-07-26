package BinarySearch;
public class RotatedSortedArray {
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {
                
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        boolean found = search(rotatedArray, target);

        if (found) {
            System.out.println("Target " + target + " exists in the rotated sorted array.");
        } else {
            System.out.println("Target " + target + " does not exist in the array.");
        }
    }
}
