package club.cser.leetcode;

class HIndex {
    public int hIndex(int[] citations) {

        int[] cnt = new int[citations.length + 1];

        for (int c: citations) {
            ++ cnt[Math.min(citations.length, c)];
        }

        int accumulate = 0;

        for (int i = cnt.length - 1; i > 0; -- i) {
            accumulate += cnt[i];

            if (accumulate >= i)
                return i;
        }

        return 0;

    }
}
