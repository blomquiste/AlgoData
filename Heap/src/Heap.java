public class Heap {
    public static Node groot;

    public static class Node {
        public Integer prio;
        public Integer size;
        public Node left;
        public Node right;

        public Node(Integer prio) {
            this.prio = prio;
            this.size = 1;
            this.left = null;
            this.right = null;
        }
    }

    public Heap() {
        groot = null;
    }

    public void add(Integer prio) {
        groot = add(groot, prio);
    }

    private Node add(Node n, Integer prio) {
        if(n == null) {
            return new Node(prio);
        }
        n.size++;
        if (prio <= n.prio) {
            int temporary = n.prio;
            n.prio = prio;
            prio = temporary;
        }
        if (n.left == null) {
            n.left = new Node(prio);
        } else if (n.right == null) {
            n.right = new Node(prio);
        } else {
            if (n.left.size <= n.right.size) {
                n.left = add(n.left, prio);
            } else {
                n.right = add(n.right, prio);
            }
        }
        return n;
    }

    public Node remove() {
        if (groot == null) {
            return null;
        } else if (groot.size == 1) {
            Node removed = groot;
            groot = null;
            return removed;
        } else {
            Node removed = groot;
            jumpAround(groot);
            return removed;
        }
    }

    public Integer jumpAround(Node n) {
        Integer abortion = n.prio;
        if (n == null) {
            return null;
        }
        n.size--;

        if (n.left == null) {
            n.prio = n.right.prio;
            if (n.right.size == 1) {
                n.right = null;
                return abortion;
            } else {
                return jumpAround(n.right);
            }
        }
        if (n.right == null) {
            n.prio = n.left.prio;
            if (n.left.size == 1) {
                n.left = null;
                return abortion;
            } else {
                return jumpAround(n.left);
            }
        }
        if (n.left.prio <= n.right.prio) {
            n.prio = n.left.prio;
            if (n.left.size == 1) {
                n.left = null;
                return abortion;
            } else {
                return jumpAround(n.left);
            }
        }
        if (n.right.prio < n.left.prio) {
            n.prio = n.right.prio;
            if (n.right.size == 1) {
                n.right = null;
                return abortion;
            } else {
                return jumpAround(n.right);
            }
        }
        return abortion;
    }

    public int push(Integer incr) {
        Integer newPrio = groot.prio + incr;
        int levels = 0;
        if (groot == null) {
            return 0;
        } else if (groot.size < 2) {
            groot.prio = newPrio;
            return levels;
        } else {
            int temp = pushh(groot, newPrio);
            levels += temp;
            //System.out.println(levels);
            return levels;
        }
    }

    public int pushh(Node n, Integer newPrio) {
        int levelD = 0;
        if((n.left == null || (newPrio < n.left.prio)) && (n.right == null || (newPrio < n.right.prio))) {
            n.prio = newPrio;
            return levelD;
        } else {
            levelD++;
            if (n.left == null) {
                n.prio = n.right.prio;
                if (n.right.size == 1) {
                    n.right.prio = newPrio;
                    return levelD;
                } else {
                    int temp = pushh(n.right, newPrio);
                    levelD += temp;
                    return levelD;
                }
            } else if (n.right == null) {
                n.prio = n.left.prio;
                if (n.left.size == 1) {
                    n.left.prio = newPrio;
                    return levelD;
                } else {
                    int temp = pushh(n.left, newPrio);
                    levelD += temp;
                    return levelD;
                }
            } else if (n.left.prio <= n.right.prio) {
                n.prio = n.left.prio;
                if (n.left.size == 1) {
                    n.left.prio = newPrio;
                    return levelD;
                } else {
                    int temp = pushh(n.left, newPrio);
                    levelD += temp;
                }
            } else if (n.right.prio < n.left.prio) {
                n.prio = n.right.prio;
                if (n.right.size == 1) {
                    n.right.prio = newPrio;
                    return levelD;
                } else {
                    int temp = pushh(n.right, newPrio);
                    levelD += temp;
                }
            }
            return levelD;
        }
    }
}
