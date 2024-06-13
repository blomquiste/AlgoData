public class LinkedQueue {
    Node head;
    Node tail;
    private class Node {
        Integer item;
        Node next;
        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public LinkedQueue() {
        head = null;
        tail = null;
    }

    public void add(Integer item) {
        if (head == null) {
            Node added = new Node(item, null);
            head = added;
            tail = added;
        } else {
            Node added = new Node(item, null);
            tail.next = added;
            tail = added;
        }
    }

    public Integer remove() {
        Node removed = head;
        head = head.next;
        return removed.item;
    }
}
