public class StaticStack {
    private int[] arr;
    private int pointer = 0;
    public int val = 0;

    public StaticStack(int size) {
        this.arr = new int[size];
    }

    public void push(int val) {
        if ((pointer < arr.length) && (arr[pointer] == 0)) {
            arr[pointer] = val;
            pointer++;
        } else {
            System.out.println("Stack out of allocated space.");
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
        return val;
    }
}
