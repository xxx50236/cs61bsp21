package IntList;

public class SLList {

    public static class IntNode {
        public int item;
        public IntNode next;
        public  IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return  first.item;
    }

    public void addLast(int x) {
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size(first);
    }

    private static int size(IntNode n) {
        if (n == null) {
            return 0;
        }
        return  1 + size(n.next);
    }
}
