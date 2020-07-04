package club.cser.leetcode;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LargestNumber {

    class NumStr {
        String str;
        String cmp;

        void fillCmp(int digit) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i <= digit / str.length(); i++) {
                sb.append(str);
            }
            cmp = sb.substring(0, digit);
        }
    }

    public String largestNumber(int[] nums) {

        int max = IntStream.of(nums).max().getAsInt();

        if (max == 0)
            return "0";

        int maxDigit = Integer.toString(max).length();

        NumStr[] numStrs = new NumStr[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = new NumStr();
            numStrs[i].str = Integer.toString(nums[i]);
            numStrs[i].fillCmp(maxDigit);
        }

        return Arrays.stream(numStrs).sorted((n1, n2) -> {
            int res = n2.cmp.compareTo(n1.cmp); // 比卫星数据
            if (res == 0)
                return n1.str.length() - n2.str.length(); // 卫星数据相等，该怎么取，这么写不对
            return res;
        }).map(n -> n.str).reduce((n1, n2) -> n1 + n2).orElse("");
    }


    public String largestNumber1(int[] nums) {
        String res = Arrays.stream(nums).mapToObj(String::valueOf).sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2)).reduce((n1, n2) -> n1 + n2).orElse("");
        if (res.charAt(0) == '0')
            return "0";
        return res;
    }
}