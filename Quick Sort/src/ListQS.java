public class ListQS {
    Node head;
    Node tail;
    static class Node {
        int value;
        Node next;

        private Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(int value) {
        if (head == null) {
            head = new Node (value);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;
        tail = newNode;
    }

    public void sort(Node low, Node high) {
        if (low == null || low == high || low == high.next) {
            return;
        }
        Node prePivot = partition(low, high);
        sort(low, prePivot);

        if (prePivot != null && prePivot == low) {
            sort(prePivot.next, high);
        } else if (prePivot != null && prePivot.next != null) {
            sort(prePivot.next.next, high);
        }
    }

    private Node partition(Node low, Node high) {
        /*if (low != high || low != null || high != null) {
            int pivot = high.value;
            Node last = high;
            Node i = low;

            while (i != high) {
                i = i.next;
            }
            Node prePivot = i;

            while (low != high) {
                if (low.value < pivot) {
                    prePivot = low;
                    low = low.next;
                } else if (low.value > pivot) {
                    last.next = low;
                    low = low.next;
                    prePivot.next = low;
                    last.next.next = null;
                    last = last.next;
                }
            }
            return prePivot;
        } else {
            return low;
        }*/


        if (low == high || low == null || high == null) {
            return low;
        }

        Node prePivot = low;
        Node current = low;
        int pivot = high.value;
        while (low != high) {
            if (low.value < pivot) {
                prePivot = current;
                swap(current, low);
                current = current.next;
            }
            low = low.next;
        }
        high.value = current.value;
        current.value = pivot;

        return prePivot;
    }

    private void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    void printList(Node n)
    {
        while (n != null) {
            System.out.print(n.value);
            System.out.print(" ");
            n = n.next;
        }
    }
}
