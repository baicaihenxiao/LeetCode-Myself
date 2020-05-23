package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MinimumHeightTreesTest {
    MinimumHeightTrees m;

    @Before
    public void init() {
        m = new MinimumHeightTrees();
    }

    @Test
    public void basicTest1() {
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        int n = 4;
        int[] res = {1};
        Assert.assertEquals(Arrays.toString(res), m.findMinHeightTrees(n, edges).toString());
    }

    @Test
    public void basicTest2() {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        int n = 6;
        int[] res = {3, 4};
        Assert.assertEquals(Arrays.toString(res), m.findMinHeightTrees(n, edges).toString());
    }

    @Test
    public void basicTest3() {
        int[][] edges = {{0, 4}, {4, 5}, {5, 3}, {1, 4}, {2, 5}};
        int n = 6;
        int[] res = {4, 5};
        Assert.assertEquals(Arrays.toString(res), m.findMinHeightTrees(n, edges).toString());
    }

    @Test
    public void basicTest4() {
        int[][] edges = {{0 ,1}};
        int n = 2;
        int[] res = {0, 1};
        Assert.assertEquals(Arrays.toString(res), m.findMinHeightTrees(n, edges).toString());
    }
}
