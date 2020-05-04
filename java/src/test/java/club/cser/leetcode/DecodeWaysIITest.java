package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DecodeWaysIITest {
    DecodeWaysII d;

    @Before
    public void init() {
        d = new DecodeWaysII();
    }

    // 这个想表达的意思是，int的最大值也是10位数，如果用int表示结果的话，直接用乘法的话会溢出，比如1000000006 * 3。
    // 溢出即模了Integer.MAX_VALUE，不管是模成了正值还是负值结果都不对。会用这个溢出结果再mod 1000000007。
    // 如果累加做模的话又写的太复杂，所以直接用long计算
    @Test
    public void overflowTest() {
        //java没有unsigned int
        final int mod = 1000000007;

        //3*1000000006%1000000007=1000000004
        /*
        加3次的结果为：1000000006
        加3次的结果为：1000000005
        加3次的结果为：1000000004
         */
        int res = 0;
        for (int i = 0; i < 3; ++ i) {
            res += 1000000006;
            res %= mod;
            System.out.println("加3次分别模的结果为：" + res);
        }

        //3*1000000006%1000000007=-294967271
        /*
        直接乘3的结果为：-1294967278
        直接乘3再模的结果为：-294967271
         */

        System.out.println("直接乘3的结果为：" + 1000000006 * 3);
        System.out.println("直接乘3再模的结果为：" + 1000000006 * 3 % mod);

        /*
        加3次不模的结果为：1000000006
        加3次不模的结果为：2000000012
        加3次不模的结果为：-1294967278
         */
        res = 0;
        for (int i = 0; i < 3; ++ i) {
            res += 1000000006;
//            res %= mod;
            System.out.println("加3次不模的结果为：" + res);
        }
        // 加3次再模的结果为：-294967271
        System.out.println("加3次再模的结果为：" + res % mod);


        System.out.println(Integer.MAX_VALUE);
        //溢出的部分852516371
        System.out.println("溢出的部分:" + (1000000006-(Integer.MAX_VALUE - 1000000006 * 2)));
        //溢出的部分852516370，这个差1是正确的，例如，如果模的结果是Integer.MIN_VALUE，说明正好溢出1
        //-1294967278为直接乘3的结果
        System.out.println("溢出的部分:" + (-1294967278 - Integer.MIN_VALUE));

    }

    @Test
    public void normalTest() {
        Assert.assertEquals(11, d.numDecodings("*1"));
        Assert.assertEquals(81 + 15, d.numDecodings("**"));
        Assert.assertEquals(2, d.numDecodings("12"));
        Assert.assertEquals(1, d.numDecodings("2"));
        Assert.assertEquals(1, d.numDecodings("52"));
        Assert.assertEquals(3, d.numDecodings("226"));
        Assert.assertEquals(9, d.numDecodings("*"));
        Assert.assertEquals(18, d.numDecodings("1*"));
        Assert.assertEquals(9 + 6, d.numDecodings("2*"));
    }

    @Test
    public void extremePositiveTest() {
        Assert.assertEquals(0 ,d.numDecodings("0"));
        Assert.assertEquals(0 ,d.numDecodings("05"));
        Assert.assertEquals(0 ,d.numDecodings("00"));
        Assert.assertEquals(0 ,d.numDecodings("50"));
        Assert.assertEquals(1 ,d.numDecodings("10"));
        Assert.assertEquals(0 ,d.numDecodings("100"));
    }

    @Test
    public void largeTest() {
        Assert.assertEquals(291868912 ,d.numDecodings("*********"));
    }

    @Test
    public void normalTestSimplified() {
        Assert.assertEquals(279, d.SimplifiedNumDecodings("*123*"));
        Assert.assertEquals(11, d.SimplifiedNumDecodings("*1"));
        Assert.assertEquals(81 + 15, d.SimplifiedNumDecodings("**"));
        Assert.assertEquals(2, d.SimplifiedNumDecodings("12"));
        Assert.assertEquals(1, d.SimplifiedNumDecodings("2"));
        Assert.assertEquals(1, d.SimplifiedNumDecodings("52"));
        Assert.assertEquals(3, d.SimplifiedNumDecodings("226"));
        Assert.assertEquals(9, d.SimplifiedNumDecodings("*"));
        Assert.assertEquals(18, d.SimplifiedNumDecodings("1*"));
        Assert.assertEquals(9 + 6, d.SimplifiedNumDecodings("2*"));
    }

    @Test
    public void extremePositiveTestSimplified() {
        Assert.assertEquals(0 ,d.SimplifiedNumDecodings("0"));
        Assert.assertEquals(0 ,d.SimplifiedNumDecodings("05"));
        Assert.assertEquals(0 ,d.SimplifiedNumDecodings("00"));
        Assert.assertEquals(0 ,d.SimplifiedNumDecodings("50"));
        Assert.assertEquals(1 ,d.SimplifiedNumDecodings("10"));
        Assert.assertEquals(0 ,d.SimplifiedNumDecodings("100"));
    }

    @Test
    public void largeTestSimplified() {
        Assert.assertEquals(291868912 ,d.SimplifiedNumDecodings("*********"));

    }
}
