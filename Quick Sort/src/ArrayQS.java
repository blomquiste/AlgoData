public class ArrayQS {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            sort(arr, low, (pIndex - 1));
            sort(arr, (pIndex + 1), high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, (i + 1), high);
        int pivotIndex = i + 1;
        return pivotIndex;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
