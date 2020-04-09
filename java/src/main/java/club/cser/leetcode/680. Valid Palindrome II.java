package club.cser.leetcode;

class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return isPalindromeWithDel(s, true);
    }
    
    public boolean isPalindromeWithDel(String s, boolean flag) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        int i = 0, j = s.length() - 1;

        while (i <= j) {

            if (!Character.isLetterOrDigit(s.charAt(i))) {
                ++ i;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                -- j;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                if (flag) {
                    return isPalindromeWithDel(s.substring(i, j), false) || isPalindromeWithDel(s.substring(i + 1, j + 1), false);
                } else {
                    return false;
                }
            }

            ++ i;
            -- j;
        }

        return true;
    }
}