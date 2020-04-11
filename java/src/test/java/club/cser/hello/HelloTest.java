package club.cser.hello;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.junit.Test;

//mvn -Dtest=HelloTest test
public class HelloTest {

    static final Logger LOGGER = LogManager.getLogger(HelloTest.class);


    //mvn -Dtest=HelloTest#test1 test
    @Test
    public void test1() {
        Hello h = new Hello();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = h.twoSum(nums, target);

        Assert.assertEquals(nums[res[0]] + nums[res[1]], target);

//        LOGGER.warn("log4jjj1111warn");
//        LOGGER.error("log4jjj1111error");

    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        Hello h = new Hello();
        int[] nums = {2, 6, 11, 15};
        int target = 9;
//        LOGGER.info("111111test2");

        int[] res = h.twoSum(nums, target);

//        Assert.assertEquals(nums[res[0]] + nums[res[1]], target);
    }

    @Test
    public void test3() {
        Hello h = new Hello();
        int[] nums = {2, 5, 11, 15};
        int target = 9;
//        LOGGER.info("111111test3");

        try {
            int[] res = h.twoSum(nums, target);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "No solution");
        }
    }


}
