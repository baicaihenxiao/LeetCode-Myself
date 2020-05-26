package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CourseScheduleIIITest {

    CourseScheduleIII c;

    @Before
    public void init() {
        c = new CourseScheduleIII();
    }

    @Test
    public void basicTest1() {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        Assert.assertEquals(3, c.scheduleCourse(courses));
    }

    //这个用例说明不能按结束期限排序贪心
    @Test
    public void basicTest2() {
        int[][] courses = {{900, 1000}, {300, 1100}, {400, 1200}};
        Assert.assertEquals(2, c.scheduleCourse(courses));
    }

    //这个用例说明不能按课程天数排序贪心
    @Test
    public void basicTest3() {
        int[][] courses = {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
        Assert.assertEquals(5, c.scheduleCourse(courses));
    }


}



