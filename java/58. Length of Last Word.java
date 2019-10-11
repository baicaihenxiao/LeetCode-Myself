package java;

class Solution {
    public int lengthOfLastWord(String s) {

        if (s == null) {
            return 0;
        }

        s = s.trim();

        int pos = s.lastIndexOf(' ');

        if (pos == -1) {
            return s.length();
        }

        return s.length() - pos - 1;
    }
}