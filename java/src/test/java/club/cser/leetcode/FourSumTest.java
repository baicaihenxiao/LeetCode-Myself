package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FourSumTest {

    FourSum t;

    @Before
    public void init() {
        t = new FourSum();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Integer[][] res = { {-1,  0, 0, 1}, {-2, -1, 1, 2}, {-2,  0, 0, 2} }; // 要用Integer[][]不能用int[][], Arrays::asList就会把{-1, 0, 1}映射成List<int[]>
        Assert.assertEquals( Arrays.stream(res).map(Arrays::asList).map(String::valueOf).sorted().collect(Collectors.toList()),
                t.fourSum(nums, target).stream().map(String::valueOf).sorted().collect(Collectors.toList()));
    }

    @Test
    public void basicTest2() {
        int[] nums = {-3,-1,0,2,4,5};
        int target = 2;
        Integer[][] res = { {-3,-1,2,4} }; // 要用Integer[][]不能用int[][], Arrays::asList就会把{-1, 0, 1}映射成List<int[]>
        Assert.assertEquals( Arrays.stream(res).map(Arrays::asList).map(String::valueOf).sorted().collect(Collectors.toList()),
                t.fourSum(nums, target).stream().map(String::valueOf).sorted().collect(Collectors.toList()));
    }

}
