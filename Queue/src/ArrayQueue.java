public class ArrayQueue {
    Integer[] queue;
    int a = 0;
    int r = 0;
    int counter = 0;

    public ArrayQueue(int n) {
        queue = new Integer[n];
        queue[r] = null;
    }


    public void add(Integer item) {
        queue[a] = item;
        a++;
        counter++;
        if (a == queue.length) {
            a = 0;
        }
        if (a == r) {
            increase();
        }
    }

    public Integer remove() {
        Integer removed = queue[r];
        queue[r] = null;
        r++;
        counter--;
        if (r == queue.length) {
            r = 0;
        }
        /*if (counter == queue.length/4) {
            decrease();
        }*/

        if (removed == null) {
            return null;
        }else {
            return removed;
        }
    }
    private void increase() {
        Integer[] newArr = new Integer[queue.length*2];

        int i = 0;
        while (i < queue.length) {
            newArr[i] = remove();
            i++;
        }
        counter += queue.length;
        r = 0;
        a = i;

        /*for (int i = 0; i < queue.length; i++) {
            if (queue[r] != null) {
                newArr[i] = queue[r];
                r++;
            } else if (queue[r] == null && r > a){
                r = 0;
                newArr[i] = queue[r];
                r++;
            } else if (queue[r] == null && r<=a) {
                r = 0;
                a = i;
                System.out.println(i);
                break;
            }
        }*/
        this.queue = newArr;
    }

    private void decrease() {
        Integer[] newArr = new Integer[queue.length/2];

        int i = 0;
        while (i < queue.length) {
            newArr[i] = remove();
            i++;
            counter++;
        }
        r = 0;
        a = i;

        /*for (int i = 0; i < newArr.length; i++) {
            if (r < queue.length) {
                newArr[i] = queue[r];
                r++;
            } else if (r == queue.length && r > a) {
                r = 0;
                newArr[i] = queue[r];
                r++;
            } else if (r == queue.length && r <= a) {
                r = 0;
                a = i;
                break;
            }
        }*/
        queue = newArr;
    }
}
