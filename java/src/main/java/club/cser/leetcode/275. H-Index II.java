package club.cser.leetcode;

class HIndexII {
    public int hIndex(int[] citations) {
        return search(citations, 0, citations.length);
    }

    private int search(int[] nums, int begin, int end) {

        if (begin >= end)
            return 0;

        int mid = begin + (end - begin) / 2;
        int paperCounts = nums.length - mid;

        if (nums[mid] == paperCounts) {
            return paperCounts;
        } else if (nums[mid] > paperCounts) {
            return Math.max(paperCounts, search(nums, begin, mid));
        } else {
            return search(nums, mid + 1, end);
        }
    }
}