package Sorting;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] myArray = { 5, 2, 9, 1, 5, 6 };

        System.out.println("Original array:");
        for (int num : myArray) {
            System.out.print(num + " ");
        }
        selectionSort(myArray);
        System.out.println("\nSorted array using Selection Sort:");
        for (int num : myArray) {
            System.out.print(num + " ");
        }
    }
}
