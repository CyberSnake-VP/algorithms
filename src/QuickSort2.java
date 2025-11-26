public class QuickSort2 {

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) return; // base case

        int pivot = arr[highIndex];

        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && rightPointer > leftPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }


    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 4, 5, 2};
        for(int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);

        for(int i: array) {
            System.out.print(i + " ");
        }
    }
}
