import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private Stack<BinaryTree.Node> stack;

    public TreeIterator(BinaryTree.Node root) {
        stack = new Stack<BinaryTree.Node>();
        BinaryTree.Node current = BinaryTree.root;
        moveLeft(current);
    }

    private void moveLeft(BinaryTree.Node current) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            System.out.println("NoSuchElementException");
        }
        BinaryTree.Node current = stack.pop();
        if (current.right != null) {
            moveLeft(current.right);
        }
        return current.value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
