package club.cser.leetcode;

class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int begin = 0, end = nums.length - 1;

        while (begin < end) {
            int pivot = randomPartition(nums, begin, end);

            if (pivot == nums.length - k)
                return nums[pivot];
            else if (pivot < nums.length - k)
                begin = pivot + 1;
            else
                end = pivot - 1;
        }

        return nums[begin];
    }

    // 调用这个超过80%
    private int randomPartition(int[] nums, int begin, int end) {

        int random = (int)(Math.random() * (end - begin) + begin);

        swap(nums, begin, random);

        return partition(nums, begin, end);

    }

    // 直接调用这个超过20%
    private int partition(int[] nums, int begin, int end) {
        int pivot = nums[begin];
        int i = begin;
        int j = begin;

        while (++ j <= end) {
            if (nums[j] < pivot) {
                swap(nums, ++ i, j);
            }
        }
        swap(nums, i, begin);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}