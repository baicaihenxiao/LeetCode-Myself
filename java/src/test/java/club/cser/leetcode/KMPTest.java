package club.cser.leetcode;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMPTest {


    static final Logger LOGGER = LogManager.getLogger(KMPTest.class);

    @Test
    public void testComputeLPS1() {
        String s = "AAAAABAAABA";
        ArrayList<Integer> list = new KMP().computeLPS(s);
//        LOGGER.info(list);
        Assert.assertEquals(list.size(), s.length());
    }

    @Test
    public void testComputeLPS2() {
        String s = "ababaca";
        ArrayList<Integer> list = new KMP().computeLPS(s);
//        LOGGER.info(list);
        Assert.assertEquals(list.size(), s.length());
    }

    @Test
    public void testKMP1() {
        String haystack = "ababaca";
        String needle = "aba";
        ArrayList<Integer> list = new KMP().computeKMP(haystack, needle);
        List<Integer> res = Lists.newArrayList(0, 2);
//        LOGGER.info(list);
        Assert.assertTrue(list.equals(res));
    }

    @Test
    public void testKMP2() {
        String haystack = "AAAAABAAABA";
        String needle = "AABA";
        ArrayList<Integer> list = new KMP().computeKMP(haystack, needle);
        List<Integer> res = Lists.newArrayList(3, 7);
//        LOGGER.info(list);
        Assert.assertTrue(list.equals(res));
    }

    @Test
    public void testKMPWithEmpty() {
        String haystack = "AAAAABAAABA";
        String needle = "";
        ArrayList<Integer> list = new KMP().computeKMP(haystack, needle);
        List<Integer> res = Lists.newArrayList(0);
//        LOGGER.info(list);
        Assert.assertTrue(list.equals(res));
    }

    @Test
    public void testKMPWithoutMatch() {
        String haystack = "AAAAABAAABA";
        String needle = "AABC";
        ArrayList<Integer> list = new KMP().computeKMP(haystack, needle);
        List<Integer> res = Lists.newArrayList(-1);
//        LOGGER.info(list);
        Assert.assertTrue(list.equals(res));
    }


    @Test
    public void aaa() {
        KMP a = new KMP();
        KMP b = new KMP();
        Class<KMP> c = (Class<KMP>) a.getClass();
//        System.out.println(a.getClass().toGenericString());
//        System.out.println(b.getClass().toGenericString());
//        System.out.println(a.getClass() == b.getClass());
//        System.out.println(a.getClass() == c);
    }

}
