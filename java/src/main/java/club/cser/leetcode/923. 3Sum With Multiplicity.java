package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int res = 0;
        final long mod = 1000000007;

        for (int i = 0; i < A.length - 2; ++ i) {
            int left = i + 1;
            int right = A.length - 1;

            while (left < right) {
                if (A[i] + A[left] + A[right] == target) {

                    if (A[left] == A[right]) { // 可以直接组合个数，这里为了避免直接算组合，{1,1,2,2,2,2} 后面4个2  C4,2 = C3,1 + C2,1 +C1,1
                        res += right - left;
                        res %= mod;
                        ++ left;
                        continue;
                    }

                    int tmpLeft = left;
                    int tmpRight = right;

                    ++ left;
                    -- right;

                    while (left <= right && A[left - 1] == A[left]) {
                        ++ left;
                    }

                    while (left <= right && A[right + 1] == A[right]) {
                        -- right;
                    }

                    res += (tmpLeft - left) * (right - tmpRight); // {1,1,2,2,2,9,9,9,9} target=12, 对于第一个1， res+=3*4，对于第二个1， res+=3*4
                    res %= mod;

                } else if (A[i] + A[left] + A[right] > target) {
                    -- right;
                } else {
                    ++ left;
                }
            }
        }

        return res;
    }

}
