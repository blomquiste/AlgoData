public class List {
    public Node head;
    public static class Node {
        public Integer prio;
        public Node next;

        public Node(Integer prio, Node next) {
            this.prio = prio;
            this.next = next;
        }
    }

    public List() {
        this.head = null;
    }

    public void add1(Integer prio) {
        if (head == null) {
            head = new Node(prio, null);
        } else {
            Node newNode = new Node(prio, head);
            head = newNode;
        }
    }

    public void addn(Integer prio) {
        if(head == null) {
            head = new Node(prio, null);
        } else {
            Node newNode = new Node(prio, head);
            head = newNode;

            Integer temp = head.prio;
            Node current = head;
            Node compare = head.next;
            while (compare.next != null && temp > compare.prio) {
                current.prio = compare.prio;
                current = current.next;
                compare = compare.next;
            }
            current.prio = temp;
            if (current.prio > compare.prio) {
                current.prio = compare.prio;
                compare.prio = temp;
            }
        }
    }

    public Integer remove1() {
        Node wanted = head;
        head = wanted.next;
        return wanted.prio;
    }

    public Integer removen() {
        if (head == null) {
            return null;
        }
        Node removed = head;
        head = head.next;
        Node current = removed;
        Integer temp = removed.prio;
        while (current.next != null) {
            if ( current.prio <= removed.prio) {
                temp = removed.prio;
                removed.prio = current.prio;
                current.prio = temp;
            }
            current = current.next;
        }
        if (current.prio <= removed.prio) {
            temp = removed.prio;
            removed.prio = current.prio;
            current.prio = temp;
        }
        return removed.prio;
    }
}
