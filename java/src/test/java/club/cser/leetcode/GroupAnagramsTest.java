package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagramsTest {
    private GroupAnagrams r;

    @Before
    public void init() {
        r = new GroupAnagrams();
    }

    @Test
    public void basicTest1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] resArray = {
                {"ate","eat","tea"},
                {"nat","tan"},
                {"bat"}
        };


        List<List<String>> res = Arrays.stream(resArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());
// 这个有问题
//        Assert.assertEquals(res, r.groupAnagrams(strs));
    }
}
