package club.cser.leetcode;

class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int res = s.chars().reduce(0, (a, b) -> a ^ b);
        return (char)t.chars().reduce(res, (a, b) -> a ^ b);
    }
}