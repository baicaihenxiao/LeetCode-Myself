package club.cser.leetcode;

import club.cser.commons.MyAssert;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringwithConcatenationofAllWordsTest {
    SubstringwithConcatenationofAllWords s;

    @Before
    public void init() {
        s = new SubstringwithConcatenationofAllWords();
    }

    @Test
    public void basicTest1() {
        String in = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> res = Arrays.asList(0,9);
        MyAssert.assertEquals(res, s.findSubstring(in, words));
    }

    @Test
    public void basicTest2() {
        String in = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        List<Integer> res = new ArrayList<>();
        MyAssert.assertEquals(res, s.findSubstring(in, words));
    }
    @Test
    public void basicTest3() {
        String in = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> res = Arrays.asList(8);
        MyAssert.assertEquals(res, s.findSubstring(in, words));
    }
}
