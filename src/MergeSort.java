public class MergeSort {

    //Основной метод сортировки. Принимает неотсортированный массив.
    private static void mergeSort(int[] array) {
        // находим длину исходного массива
        int length = array.length;
        if (length <= 1) return; // базовый случай и выход из рекурсии

        /**
         * 1. Получаем точку для разделения массива на равные части
         * 2. Массив для левой части
         * 3. Массив для правой части*
         */

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // указатель на индекс левого массива
        int j = 0; // указатель на индекс правого массива

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }


    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 1, 6, 4};
        System.out.println("unsorted");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        mergeSort(array);

        System.out.println("sorted");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}




