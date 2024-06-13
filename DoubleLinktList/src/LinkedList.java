public class LinkedList {
    Cell first;

    public LinkedList(int n) {
        Cell newCell = null;
        for (int i = n; i > 0; i--) {
            newCell = new Cell(i, newCell);
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
    }

    private void traverse(int n) {
        Cell current = this.first;
        for(int i = 0; i < n; i++) {
            current = current.tail;
        }
    }
    public void unlink(int n) {
        Cell current = this.first;
        if (n == 0) {
            Cell unlinkedCell = current;
            first = current.tail;
            add(unlinkedCell.head);
        } else {
            current = first.tail;
            Cell previous = first;
            for (int i = 0; i < n-1; i++) {
                current = current.tail;
                previous = previous.tail;
                i++;
            }
            Cell unlinkedCell = current;
            previous.tail = current.tail;
            add(unlinkedCell.head);
        }
    }
}

