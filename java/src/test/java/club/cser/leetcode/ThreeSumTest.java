package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSumTest {

    ThreeSum t;

    @Before
    public void init() {
        t = new ThreeSum();
    }

    @Test
    public void basicTest1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Integer[][] res = { {-1, 0, 1}, {-1, -1, 2} }; // 要用Integer[][]不能用int[][], Arrays::asList就会把{-1, 0, 1}映射成List<int[]>
        Assert.assertEquals( Arrays.stream(res).map(Arrays::asList).map(String::valueOf).sorted().collect(Collectors.toList()),
                t.threeSum(nums).stream().map(String::valueOf).sorted().collect(Collectors.toList()));
    }

    @Test
    public void basicTest2() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1};
        Integer[][] res = { {-1, 0, 1}, {-1, -1, 2} };
/*        Assert.assertEquals( Arrays.stream(res)
                .map(Arrays::asList)
                .collect(Collectors.toList()), t.threeSum(nums));*/

        Assert.assertEquals( Arrays.stream(res).map(Arrays::asList).map(String::valueOf).sorted().collect(Collectors.toList()),
                t.threeSum(nums).stream().map(String::valueOf).sorted().collect(Collectors.toList()));
    }

    @Test
    public void cornerTest1() {
        int[] nums = {0,0,0,0};
        Integer[][] res = { {0,0,0} };
        Assert.assertEquals( Arrays.stream(res).map(Arrays::asList).map(String::valueOf).sorted().collect(Collectors.toList()),
                t.threeSum(nums).stream().map(String::valueOf).sorted().collect(Collectors.toList()));
    }



}