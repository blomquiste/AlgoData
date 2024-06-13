import java.util.Iterator;

public class BinaryTree implements Iterable<Integer> {
    public static Node root;

    public static class Node {
        public Integer key;
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

    public void add(Integer key, Integer value) {
        if(root == null) {
            root = new Node(key, value);
        } else {
            root = add(root, key, value);
        }
    }

    private Node add(Node n, Integer key, Integer value) {
        if (n == null) {
            n = new Node(key, value);
        } else if (key == n.key) {
            n.value = value;
        } else if (key < n.key) {
            n.left = add(n.left, key, value);
        } else if (key > n.key) {
            n.right = add(n.right, key, value);
        }
        return n;
    }

    public Integer lookup(Integer key) {
        return lookup(root, key);
    }

    public Integer lookup(Node n, Integer key) {
        if (n == null) {
            return null;
        } else if (key == n.key) {
            return n.value;
        } else if (key < n.key) {
            return lookup(n.left, key);
        } else {
            return lookup(n.right, key);
        }
    }

    /******* MANNENS KOD ********  funkar ju inte ens.
    public void print() {
        if(left != null)
            left.print();
        System.out.println(" key: " + key + "\tvalue: " + value);
        if(right != null)
            right.print();
    }*/
}
