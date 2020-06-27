package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseNodesinkGroupTest {
    ReverseNodesinkGroup r;

    @Before
    public void init() {
        r = new ReverseNodesinkGroup();
    }

    @Test
    public void basicTest1() {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode res = r.reverseKGroup(h, k);

        int[] resList = {2, 1, 4, 3, 5};
        int i = 0;

        while (res != null) {
//            System.out.println(res.val + " ");
            Assert.assertEquals(res.val, resList[i]);
            res = res.next;
            ++ i;
        }
    }
}
