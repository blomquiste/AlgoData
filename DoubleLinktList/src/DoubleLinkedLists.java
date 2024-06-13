public class DoubleLinkedLists {
    Cell first;
    Cell last;
    Cell current;
    public Cell[] cellIndex;

    public DoubleLinkedLists(int n) {
        int i = n;
        this.first = new Cell(i, null, null);
        this.last = first;
        i--;

        while (i > 0) {
            Cell newCell = new Cell(n, first, null);
            first.previous = newCell;
            first = newCell;
            i--;
        }
        arrayIt(n);
    }


    public class Cell {
        int head;
        Cell next;
        Cell previous;


        Cell(int val, Cell next, Cell previous) {
            head = val;
            this.next = next;
            this.previous = previous;
        }
    }

    private void arrayIt(int n)  {
        cellIndex = new Cell[n];
        //System.out.println(cellIndex.length);
        Cell current = this.first;
        for (int i = 0; i < n; i++) {
            cellIndex[i] = current;
            current = current.next;
        }
    }

    public void add(int item) {
        Cell newCell = new Cell(item, first, null);
        first = newCell;
    }//: add the item as the first cell in the sequence.

    public int length() {
        Cell current = first;
        int counter = 0;
        while (current != null) {
            counter ++;
            current = current.next;
        }
        return counter;
    }//: return the length of the sequence.

    public boolean find(int item) {
        Cell current = first;
        while (current != null) {
            if(current.head == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }//: return true or false depending on if the item can be found in the sequence.

    public void remove(int item) {
        Cell current = this.first;
        Cell next = current.next;
        Cell prev = current.previous;
        while (current != null) {
            if (current.head == item) {
                if (prev == null) {
                    next.previous = null;
                    current = current.next;
                }
                else if (prev != null && next != null){
                    prev.next = current.next;
                    next.previous = current.previous;
                }
                else {
                    prev.next = current.next;
                    prev = this.last;
                }
            }
            current = current.next;
        }
    }// remove the item if it exists in the sequence.

    private void traverse(int cpi) {
        if (cpi == 0) {
            this.current = first;
        }else {
            Cell temp = this.first;
            for(int i = 0; i < cpi; i++) {
                temp = temp.next;
            }
            this.current = temp;
        }
    }

    public void unlink(Cell chosen) {
        if (chosen == first) {
            first = chosen.next;
            first.previous = null;
        } else if (chosen == last) {
            last = chosen.previous;
            last.next = null;
        } else {
            chosen.previous.next = chosen.next;
            chosen.next.previous = chosen.previous;
        }
        insert(0, chosen);

        /*
        Cell chosen = cellIndex[i];
        if (i == 0){
            first = chosen.next;
            first.previous = null;
        }else if (i == last.head-1) {
            last = chosen.previous;
            last.next = null;
        }else {
            chosen.previous.next = chosen.next;
            chosen.next.previous = chosen.previous;
        }
        insert(0, chosen);*/
    }

    public void insert(int n, Cell newCell) {
        Cell current = this.first;
        traverse(n);
        newCell.previous = current.previous;
        newCell.next = current;
        current.previous = newCell;
        current.previous.next = newCell;
    }
}

