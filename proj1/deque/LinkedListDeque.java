package deque;

public class LinkedListDeque<T> {
    private final LinkedNode sentF;
    private final LinkedNode sentB;
    private int size = 0;
    public class LinkedNode {
        public LinkedNode prev;
        public T item;
        public LinkedNode next;

        public LinkedNode(T i, LinkedNode p, LinkedNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentF = new LinkedNode(null, null, null);
        sentB = new LinkedNode(null, null, null);
        sentF.next = sentB;
        sentB.prev = sentF;
    }

    public void addFirst(T item) {
        LinkedNode node = new LinkedNode(item, sentF, sentF.next);
        sentF.next.prev = node;
        sentF.next = node;
        size++;
    }

    public void addLast(T item) {
        LinkedNode node = new LinkedNode(item, sentB.prev, sentB);
        sentB.prev.next = node;
        node.next = sentB;
        sentB.prev = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedNode node = sentF.next;
        String result = "" + node.item;
        String delimiter = " ";
        for (int i = 1; i < size; i++) {
            result = result + delimiter + node.item;
            node = node.next;
        }
        System.out.println(result);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        LinkedNode node = sentF.next;
        sentF.next = node.next;
        node.next.prev = sentF;

        node.prev = null;
        node.next = null;
        size -= 1;
        return node.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        LinkedNode node = sentB.prev;
        node.prev.next = sentB;
        sentB.prev = node.prev;

        node.next = null;
        node.prev = null;
        size -= 1;
        return node.item;
    }

    public T get(int index) {
        if (index < 0 && index >= size) {
            return null;
        }

        LinkedNode node = sentF.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public T getRecursive(int index) {
        if (index < 0 && index >= size) {
            return null;
        }

        return getRecursiveNode(index, sentF.next);
    }

    /**
     * A helper method for get recursive
     * @param index node index
     * @param node previous node for desired node
     * @return The desired node value of T type
     */
    private T getRecursiveNode(int index, LinkedNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveNode(index - 1, node.next);
    }
}
