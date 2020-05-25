package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CourseScheduleTestII {

    CourseScheduleII c;

    @Before
    public void init() {
        c = new CourseScheduleII();
    }

    @Test
    public void basicTest1() {
        int numCourses = 2;
        int[][] prerequisites = { {1,0} };
        int[] res = {0, 1};
//        Assert.assertArrayEquals(res, c.findOrder(numCourses, prerequisites));
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(c.findOrder(numCourses, prerequisites)));
    }

    @Test
    public void basicTest2() {
        int numCourses = 2;
        int[][] prerequisites = { {1,0}, {0,1}};
        int[] res = {};
//        Assert.assertArrayEquals(res, c.findOrder(numCourses, prerequisites));
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(c.findOrder(numCourses, prerequisites)));

    }

    @Test
    public void basicTest3() {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] res1 = {0,1,2,3};
        int[] res2 = {0,2,1,3};
        Assert.assertTrue(
                Arrays.toString(res1).equals(Arrays.toString(c.findOrder(numCourses, prerequisites))) ||
                Arrays.toString(res2).equals(Arrays.toString(c.findOrder(numCourses, prerequisites)))
        );
    }

    @Test
    public void cornerTest1() {
        int numCourses = 1;
        int[][] prerequisites = { };
        int[] res = {0};
//        Assert.assertArrayEquals(res, c.findOrder(numCourses, prerequisites));
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(c.findOrder(numCourses, prerequisites)));
    }

    @Test
    public void cornerTest2() {
        int numCourses = 4;
        int[][] prerequisites = { };
        int[] res = {0, 1, 2, 3};
//        Assert.assertArrayEquals(res, c.findOrder(numCourses, prerequisites));
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(c.findOrder(numCourses, prerequisites)));
    }


}
