//2018-05-01 14:37:41
//答案里，如果假设字符集大小128个，可以直接创建128大小的数组解决。

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null)
            return 0;

        int tail = 0;

        int res = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i != s.length(); ++ i) {
            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) >= tail) {
                tail = hm.get(s.charAt(i)) + 1;
            }

            hm.put(s.charAt(i), i);


            if (res < i - tail + 1)
                res = i - tail + 1;
            
            //System.out.println(res);

        }

        return res;
        
    }
}