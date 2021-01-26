package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StoneGameIVTest {

    private StoneGameIV s;

    @Before
    public void init() {
        s = new StoneGameIV();
    }

    @Test
    public void basicTest1() {
        int n = 4;
        boolean res = true;

        Assert.assertEquals(res, s.winnerSquareGame1(n));
    }

    @Test
    public void basicTest2() {
        int n = 7;
        boolean res = false;

        Assert.assertEquals(res, s.winnerSquareGame1(n));
    }

    @Test
    public void basicTest3() {
        int n = 17;
        boolean res = false;

        Assert.assertEquals(res, s.winnerSquareGame1(n));
    }

    @Test
    public void basicTest4() {
        int n = 2;
        boolean res = false;

        Assert.assertEquals(res, s.winnerSquareGame1(n));
    }

    @Test
    public void basicTest5() {
        int n = 1;
        boolean res = true;

        Assert.assertEquals(res, s.winnerSquareGame1(n));
    }


}


