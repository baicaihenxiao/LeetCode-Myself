package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseScheduleTest {

    CourseSchedule c;

    @Before
    public void init() {
        c = new CourseSchedule();
    }

    @Test
    public void basicTest1() {
        int numCourses = 2;
        int[][] prerequisites = { {1,0} };
        Assert.assertEquals(true, c.canFinish(numCourses, prerequisites));
    }

    @Test
    public void basicTest2() {
        int numCourses = 2;
        int[][] prerequisites = { {1,0}, {0,1}};
        Assert.assertEquals(false, c.canFinish(numCourses, prerequisites));
    }

    @Test
    public void basicTest3() {
        int numCourses = 4;
        int[][] prerequisites = { {1,0}, {0,2}};
        Assert.assertEquals(true, c.canFinish(numCourses, prerequisites));
    }

    /*
    0 -> 1
    | /
    2
     */
    @Test
    public void basicTest4() {
        int numCourses = 3;
        int[][] prerequisites = { {0,1},{0,2},{1,2} };
        Assert.assertEquals(true, c.canFinish(numCourses, prerequisites));
    }

    @Test
    public void basicTest5() {
        int numCourses = 7;
        int[][] prerequisites = { {1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4} };
        Assert.assertEquals(true, c.canFinish(numCourses, prerequisites));
    }
}
