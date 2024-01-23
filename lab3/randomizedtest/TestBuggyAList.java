package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testAddThreeThreeMove() {
        AListNoResizing<Integer> correctList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        correctList.addLast(4);
        correctList.addLast(5);
        correctList.addLast(6);

        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(6);

        int a = correctList.removeLast();
        int b = buggyAList.removeLast();

        assertEquals(a, b);

        a = correctList.removeLast();
        b = buggyAList.removeLast();

        assertEquals(a, b);

        a = correctList.removeLast();
        b = buggyAList.removeLast();

        assertEquals(a, b);
    }
}
