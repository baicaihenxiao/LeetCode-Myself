class Solution {
       public int strStr(String haystack, String needle) {
        return computeKMP(haystack, needle).get(0);
    }

    public ArrayList<Integer> computeKMP(String haystack, String needle) {
        //找出所有匹配的位置
        ArrayList<Integer> res = new ArrayList<>();

        //空needle返回0
        if (needle == null || needle.length() == 0) {
            res.add(0);
            return res;
        }

        //不匹配返回-1
        if (haystack.length() < needle.length()) {
            res.add(-1);
            return res;
        }

        ArrayList<Integer> lps = computeLPS(needle);

        int i = 0, j = 0; //i迭代haystack, j迭代needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {//字符相等
                ++ i;
                ++ j;

                //找到一个全匹配
                if (j == needle.length()) {
                    res.add(i - j); //添加到结果中
                    j = lps.get(j - 1); //haystack[i]再和needle[0 ~ j-1]的最大前后缀进行对比，即j = \pi(j) = lps[j - 1]
                }

            } else {//字符不相等
                if (j != 0) {//不为0找needle[0 ~ j-1]的下一个最大前后缀
                    j = lps.get(j - 1);
                } else {//直接对比haystack的下一个字符
                    ++ i;
                }
            }
        }
        
        //不匹配返回-1
        if (res.isEmpty()) {
            res.add(-1);
        }

        return res;
    }

    public ArrayList<Integer> computeLPS(String needle) {
        ArrayList<Integer> lps = new ArrayList<>(needle.length());

        int len = 0; //len表示当前最大前后缀的长度
        lps.add(0); //第0个字符前后缀长度为0,  不能lps.set(0, 0)，因为new ArrayList<>(needle.length())是初始化capacity，而不是size
        int i = 1; //从1开始迭代

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                //如果第i个字符和第len个字符匹配（不是needle.charAt(len+1)是因为len表示串的长度，charAt(len)刚好是要检测的下一个字符）
                ++ len;
                lps.add(len);//那么[0~i]子串的最长前后缀长度为[0~i-1]子串的最长前后缀的长度+1
                ++ i;
            } else {//不匹配
                if (len != 0) {//[0~i-1]的最长前后缀不为0，则利用\pi[i]计算下一个前后缀
                    len = lps.get(len - 1);
                } else {//否则[0~i]子串的最长前后缀长度为0，开始向后一个匹配
                    lps.add(0);
                    ++ i;
                }
            }
        }

        return lps;
    }
}