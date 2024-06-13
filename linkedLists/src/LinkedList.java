public class LinkedList {
    Cell first;

    public LinkedList(int n) {
        Cell newCell = null;
        for (int i = 0; i < n; i++) {
             newCell = new Cell(n, newCell);
            first = newCell;
        }
    }

    private class Cell {
        int head;
        Cell tail;

        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    public void add(int item) {
        Cell newCell = new Cell(item, first);
        first = newCell;
    }//: add the item as the first cell in the sequence.

    public int length() {
        Cell current = first;
        int counter = 0;
        while (current != null) {
            counter ++;
            current = current.tail;
        }
        return counter;
    }//: return the length of the sequence.

    public boolean find(int item) {
        Cell current = first;
        while (current != null) {
            if(current.head == item) {
                return true;
            }
            current = current.tail;
        }
        return false;
    }//: return true or false depending on if the item can be found in the sequence.

    public void remove(int item) {
        Cell current = first;
        Cell prev = null;
        while (current != null) {
            if (current.head == item) {
                if (prev == null) {
                    current = current.tail;
                }
                else {
                    prev.tail = current.tail;
                }
            }
            current = current.tail;
        }
    }// remove the item if it exists in the sequence.

    public void append (LinkedList b) {
        Cell current = first;
        while (current.tail != null) {
            current = current.tail;
        }
        if (current.tail == null) {
            current.tail = b.first;
        }
    }
}

