public class Sorts {

    public static int[] selection_sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length ; j++) {
                if(array[j] < array[min_index]){
                    min_index = j;
                }
            }
            if(min_index != i) {
                int temp = array[i];
                array[i] = array[min_index];
                array[min_index] = temp;
            }
        }
        return array;
    }

    public static int[] insertion_sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            for(int j = i -1; j >= 0 && array[j] > key ;j--) {
                int temp = array[j];
                array[j] = key;
                array[j+1] = temp;
            }
        }
        return array;
    }

    public static void merge_sort(int[] array) {
        sort(array, 0, array.length -1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + ((hi-lo)/ 2);
            sort(array, lo, mid);
            sort(array, (mid+1), hi);
            merge(array, lo, mid, hi);
        }
    }

    private static void merge(int[] array, int lo, int mid, int hi) {
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        int i = lo; // the index in the first part
        int j = mid +1; // the index in the second part

        for ( int ind = lo; ind <= hi; ind++) {
            if ( i > mid && j <= hi) {
                array[ind] = temp[j];
                j++;
            }else if ( j > hi && i <= mid) {
                 array[ind] = temp[i] ;
                i++;
            }else if (temp[i] < temp[j]) {
                array[ind] = temp[i];
                i++;
            }else if ( temp[i] > temp[j]){
                array[ind] = temp[j];
                j++;
            }
        }
    }
}
