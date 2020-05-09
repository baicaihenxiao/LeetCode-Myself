package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class InterleavingStringTest {
    InterleavingString i;

    @Before
    public void init() {
        i = new InterleavingString();
    }

    @Test
    public void basicTest1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Assert.assertEquals(true, i.isInterleave(s1, s2, s3));
    }

    @Test
    public void basicTest2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Assert.assertEquals(false, i.isInterleave(s1, s2, s3));
    }

    @Test
    public void emptyStringTest1() {
        String s1 = "", s2 = "dbbca", s3 = "dbbca";
        Assert.assertEquals(true, i.isInterleave(s1, s2, s3));
    }

    @Test
    public void emptyStringTest2() {
        String s1 = "dbbca", s2 = "", s3 = "dbbca";
        Assert.assertEquals(true, i.isInterleave(s1, s2, s3));
    }

    @Test
    public void emptyStringTest3() {
        String s1 = "", s2 = "", s3 = "";
        Assert.assertEquals(true, i.isInterleave(s1, s2, s3));
    }

    @Test
    public void emptyStringTest4() {
        String s1 = "dbbck", s2 = "", s3 = "dbbca";
        Assert.assertEquals(false, i.isInterleave(s1, s2, s3));
    }


}
