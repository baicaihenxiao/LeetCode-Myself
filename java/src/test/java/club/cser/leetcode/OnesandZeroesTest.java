package club.cser.leetcode;

import club.cser.commons.MyAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OnesandZeroesTest {

    private OnesandZeroes s;

    @Before
    public void init() {
        s = new OnesandZeroes();
    }

    @Test
    public void basicTest1() {
        String[] num = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        int res = 4;
        Assert.assertEquals(res, s.findMaxForm(num, m, n));
    }
    @Test
    public void basicTest2() {
        String[] num = {"10","0","1"};
        int m = 1;
        int n = 1;
        int res = 2;
        Assert.assertEquals(res, s.findMaxForm(num, m, n));
    }

}
