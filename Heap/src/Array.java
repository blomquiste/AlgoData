public class Array {
    public int[] array;
    int n;
    int size;

    public Array(int n) {
        this.n = n;
        this.size = 0;
        array = new int[n];
        array[0] = Integer.MIN_VALUE;
    }

    public void bubble(int prio) {
        if (size >= n) {
            return;
        }
        if (array[0] == Integer.MIN_VALUE) {
            array[0] = prio;
            return;
        }

        array[++size] = prio;
        int current = size;

        if (current % 2 == 0) {
            while (current != 0 && array[current] <= array[(current-2)/2]) {
                int temp = array[current];
                array[current] = array[(current-2)/2];
                array[(current-2)/2] = temp;
                current = array[(current-2)/2];
            }
        } else {
            while (current != 0 && array[current] <= array[(current-1)/2]) {
                int temp = array[current];
                array[current] = array[(current-1)/2];
                array[(current-1)/2] = temp;
                current = array[(current-1)/2];
            }
        }
    }

    public int sink() {
        int removed = array[0];
        array[0] = array[size];
        int sunk = 0;

        while ((sunk*2)+2 < size && (array[sunk] > (array[(sunk*2)+2]) || array[sunk] > array[(sunk*2)+1])) {
            if (array[(sunk*2)+1] <= array[(sunk*2)+2]) {
                int temp = array[sunk];
                array[sunk] = array[(sunk*2)+1];
                array[(sunk*2)+1] = temp;
                sunk = (sunk*2)+1;
            } else {
                int temp = array[sunk];
                array[sunk] = array[(sunk*2)+2];
                array[(sunk*2)+2] = temp;
                sunk = (sunk*2)+2;
            }
        }
        size--;
        return removed;
    }
}
