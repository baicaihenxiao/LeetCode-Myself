package club.cser.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hello {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i = 0; i != nums.length; ++ i) {
            if (h.containsKey(target - nums[i])) {
                return new int[]{h.get(target - nums[i]), i};
            } else {
                h.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( f2() ));
    }

    static int[] f2(){
        int[] ret = new int[]{0};
        try {
            return ret;  // 返回 [1]，finally内的修改效果起了作用
        } finally {
            ret[0]++;
            System.out.println("finally执行");
        }
    }
}
