package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleTest {

    Triangle t;

    @Before
    public void init() {
        t = new Triangle();
    }


    @Test
    public void simpleTest() {
        Integer[][] num={ {2}, {3,4}, {6,5,7}, {4, 1, 8, 3} };

        List<List<Integer>> triangle = Arrays.stream(num)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        Assert.assertEquals(11, t.minimumTotal(triangle));

    }
}
