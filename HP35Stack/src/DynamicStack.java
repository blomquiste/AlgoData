public class DynamicStack {
    private int[] arr;
    private int pointer = 0;
    private int counter = 0;
    public int val = 0;

    public DynamicStack() {
        this.arr = new int[4];
    }

    public void push(int val) {
        int[] temp = new int[arr.length];
        if ((pointer < arr.length) && (arr[pointer] == 0)) {
            arr[pointer] = val;
            pointer++;
            counter ++;
        } else if (pointer == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = new int[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
            arr[pointer] = val;
            pointer++;
            counter++;
        } else {
            System.out.println("Stack seems to be dead.");
        }
    }

    public int pop(){
        if ((pointer > 0) && (arr[pointer-1] != 0)) {
            val = arr[pointer-1];
            arr[pointer-1] = 0;
            pointer--;
        } else {
            System.out.println("Stack is empty.");
        }
        if (counter == (pointer * 2)+1) {
            int[] temp = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = new int[temp.length / 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
            }
        }
        return val;
    }
}
