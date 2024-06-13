public class Search {

    public static boolean unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean linear(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean binary(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            int middleIndex = ((first + last)/2);
            if (array[middleIndex] == key) {
                return true;
            }
            if (array[middleIndex] < key && middleIndex < last) {
                first = middleIndex +1;
                continue;
            }
            if (array[middleIndex] > key && middleIndex > first) {
                last = middleIndex -1;
                continue;
            }
            break;
        }
        return false;
    }

    public static boolean superBinary(int[] array, int key, int next) {
        int first = 0;
        int last = array.length - 2;
        for (int i = 0; i < array.length - 2; i++) {
            int middleIndex = ((first + last) / 2);
            if (array[middleIndex] == key) {
                return true;
            }
            if (array[middleIndex] < key && middleIndex < last) {
                first = middleIndex + 1;
                i++;
            }
            if (array[middleIndex] > key && middleIndex > first) {
                last = middleIndex - 1;
                i++;
            }
            if (array[middleIndex + 1] < next) {
                i++;
            }
            if (array[middleIndex + 1] >= next) {
                break;
            }
        }
        return false;
    }

    //**************  DUPLICATES  **************

    public static int unsortedDuplicates(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean dup = linear(arr2, arr1[i]);
            if (dup) {
                count++;
            }
        }
        return count;
    }

    public static int sortedDuplicates(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean dup = unsorted(arr2, arr1[i]);
            if (dup) {
                count++;
            }
        }
        return count;
    }

    public static int binaryDuplicates(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean dup =  binary(arr2, arr1[i]);
            if (dup) {
                count++;
            }
        }
        return count;
    }

    public static int superBinaryDuplicates(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length -2; i++) {
            boolean dup =  superBinary(arr2, arr1[i], arr1[i+1]);
            if (dup) {
                count++;
            }
        }
        return count;
    }
}