package club.cser.leetcode;

import club.cser.commons.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PalindromePartitioningTest {
    private PalindromePartitioning l;

    @Before
    public void init() {
        l = new PalindromePartitioning();
    }

    @Test
    public void basicTest1() {
        String s = "aab";
        String jsonString = "[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]";
        List<List<String>> res =  Converter.JSONTo2DList(jsonString);
        Assert.assertEquals(res, l.partition(s));


    }

    @Test
    public void basicTest2() {
        String s = "a";
        String jsonString = "[[\"a\"]]";
        List<List<String>> res =  Converter.JSONTo2DList(jsonString);
        Assert.assertEquals(res, l.partition(s));

    }

    @Test
    public void basicTest3() {
        String s = "abbab";
        String jsonString = "[[\"a\",\"b\",\"b\",\"a\",\"b\"],[\"a\",\"b\",\"bab\"],[\"a\",\"bb\",\"a\",\"b\"],[\"abba\",\"b\"]]";
        List<List<String>> res =  Converter.JSONTo2DList(jsonString);
        Assert.assertEquals(res, l.partition(s));
    }

}
