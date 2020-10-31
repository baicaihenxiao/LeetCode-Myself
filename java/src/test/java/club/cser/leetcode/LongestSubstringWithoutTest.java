package club.cser.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

//3. Longest Substring Without Repeating Characters.java
public class LongestSubstringWithoutTest {


    static final Logger LOGGER = LogManager.getLogger(LongestSubstringWithoutTest.class);

    @Test
    public void sss() {
        LongestSubstringWithout t = new LongestSubstringWithout();
        Assert.assertEquals(3, t.lengthOfLongestSubstring("pwwkew"));;

    }

}
