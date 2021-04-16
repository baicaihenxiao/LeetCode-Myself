package club.cser.leetcode;

class LongestChunkedPalindromeDecomposition {

    // greedy
    public int longestDecomposition(String text) {
        final int N = text.length();
        int res = 0;
        String begin = "";
        String end = "";
        for (int i = 0; i < N / 2; i++) {

            begin += text.charAt(i);
            end = text.charAt(N - i - 1) + end;
            if (begin.equals(end)) {
                res += 2;
                begin = "";
                end = "";
            }
        }
        return (begin.isEmpty() && N % 2 == 0)  ? res : res + 1;
    }
}