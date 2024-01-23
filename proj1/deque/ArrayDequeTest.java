package deque;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void testEmptyAndSize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertTrue("A newly initialized ArrayDeque should be empty", a.isEmpty());
        a.addLast(1);
        assertEquals(1, a.size());

        a.addLast(2);
        assertEquals(2, a.size());

        a.addFirst(3);
        assertEquals(3, a.size());

        System.out.println("The Queue");
        a.printDeque();
    }

    @Test
    public void addRemoveTestWithoutResize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        assertEquals(1, (int)a.removeFirst());
        assertTrue(a.isEmpty());

        for (int i = 0; i < 8; i++) {
            a.addFirst(i);
        }
        assertEquals(8, a.size());
        for (int i = 7; i >= 0; i--) {
            assertEquals(i, (int)a.removeFirst());
        }
        assertTrue(a.isEmpty());

        for (int i = 0; i < 8; i++) {
            a.addLast(i);
        }
        assertEquals(8, a.size());
        for (int i = 7; i >= 0 ; i--) {
            assertEquals(i, (int)a.removeLast());
        }

        for (int i = 0; i < 8; i++) {
            a.addLast(i);
        }
        for (int i = 0; i < 8; i++) {
            assertEquals(i, (int)a.removeFirst());
        }

        for (int i = 0; i < 8; i++) {
            a.addFirst(i);
        }
        for (int i = 0; i < 8; i++) {
            assertEquals(i, (int)a.removeLast());
        }

        ArrayDeque<String> b = new ArrayDeque<>();
        b.addLast("a");
        b.addLast("b");
        b.addFirst("c");
        b.addLast("d");
        b.addFirst("e");
        b.addFirst("f");
        b.addLast("g");
        b.addFirst("h");
        b.printDeque();
    }

    @Test
    public void addRemoveTestWithResize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        int testSize = 10;

        for (int i = 0; i < 8; i++) {
            a.addFirst(i);
        }
        System.out.println("before array is full:");
        a.printDeque();
        a.addFirst(8);
        a.addFirst(9);
        System.out.println("after resize");
        a.printDeque();
        assertEquals(testSize, a.size());
        for (int i = testSize - 1; i >= 0; i--) {
            assertEquals(i, (int)a.removeFirst());
        }
        assertTrue(a.isEmpty());

        for (int i = 0; i < testSize; i++) {
            a.addLast(i);
        }
        assertEquals(testSize, a.size());
        for (int i = testSize - 1; i >= 0 ; i--) {
            assertEquals(i, (int)a.removeLast());
        }

        for (int i = 0; i < testSize; i++) {
            a.addLast(i);
        }
        for (int i = 0; i < testSize; i++) {
            assertEquals(i, (int)a.removeFirst());
        }

        for (int i = 0; i < testSize; i++) {
            a.addFirst(i);
        }
        for (int i = 0; i < testSize; i++) {
            assertEquals(i, (int)a.removeLast());
        }

        testSize = 80;
        double usageRatio = 0.04;
        for (int i = 0; i < testSize; i++) {
            if((i % 2) == 0) {
                a.addFirst(i);
            } else {
                a.addLast(i);
            }
        }

        for (int i = 0; i < testSize; i++) {
            if((i % 2) == 0) {
                a.removeFirst();
            } else {
                a.removeLast();
            }

             if ((double)a.size()/testSize <= usageRatio) {
                 System.out.println("current ratio:");
                 System.out.println(a.usageRatio());
                 break;
             }

        }

    }

}
