package club.cser.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class SortAnArray {
    public int[] sortArray(int[] nums) {
//        return bubbleSort(nums);
//        return insertionSort(nums);
//        return selectionSort(nums);
//        return maxHeapSort(nums);
//        new QuickSort().quickSort(nums, 0, nums.length - 1);
        new MergeSort().mergesortTopDown(nums, 0, nums.length - 1);
        return nums;

    }

    public int[] bubbleSort(int[] nums) {

        for (int i = 1; i < nums.length; ++ i) {
            for (int j = 0; j < nums.length - i; ++ j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++ i) {
            for (int j = i; j > 0; -- j) {
                if (nums[j - 1] > nums[j])
                    swap(nums, j, j - 1);
                else
                    break;
            }
        }
        return nums;
    }

    public int[] selectionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++ i) {
            int tmpMin = i - 1;
            for (int j = i; j < nums.length; ++ j) {
                if (nums[tmpMin] > nums[j])
                    tmpMin = j;
            }
            if (tmpMin != i - 1)
                swap(nums, tmpMin, i - 1);
        }
        return nums;
    }

    // 最大堆，用来升序排序
    public int[] maxHeapSort(int[] nums) {

        // 建堆
        for (int i = nums.length / 2 - 1; i >= 0; -- i) {
            maxHeapify(nums, i, nums.length);
        }

        // 排序
        int curHeapSize = nums.length;
        while (curHeapSize > 1) {
            swap(nums, 0, curHeapSize - 1);
            -- curHeapSize;
            maxHeapify(nums, 0, curHeapSize);
        }

        return nums;
    }

    // 最大堆，把小的元素不停下沉，使满足 nums[parent(i)] > nums[i]
    public void maxHeapify(int[] nums, int curIndex, int heapSize) {
        while (curIndex < heapSize) {
            int left = 2 * curIndex + 1;
            int right = 2 * curIndex + 2;
            int maxIndex = curIndex;
            if (left < heapSize && nums[maxIndex] < nums[left])
                maxIndex = left;
            if (right < heapSize && nums[maxIndex] < nums[right])
                maxIndex = right;

            if (maxIndex == curIndex)
                break;

            swap(nums, curIndex, maxIndex);
            curIndex = maxIndex;
        }
    }


    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}

/**
 * [left, right] right是包含的
 */
class QuickSort {
    public void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            int mid = partitionLomuto(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    // Lomuto’s Partition Scheme
    public int partitionLomuto(int[] nums, int left, int right) {
//        int pivotIndex = new Random().nextInt(right - left + 1) + 5;
        int pivot = nums[right];

        // i + 1 左边的都小于等于pivot， i + 1
        int i = left - 1;

        for (int j = left; j < right; ++ j) {
            if (nums[j] <= pivot) {
                ++ i;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);

        return i + 1;
    }

    // Hoare’s Partition Scheme
    // 我这个写法有问题 https://www.geeksforgeeks.org/hoares-vs-lomuto-partition-scheme-quicksort/
    public int partitionHoare(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left - 1;
        int j = right + 1;

        while (true) {
            /*
            只能用do while，如果用while的话 初始化i = left, j = right
            对于{5,1,1,2,0,0}这种情况
            迭代1次 {0,1,1,2,0,5} i=0, j=5
            迭代2次 {0,1,1,2,0,5} i=0, j=4 然后就停到这儿不动了

             也因为用do while，所以i j 初始化了 -1 +1

             这个while循环判断条件没有 i < j, 因为pivot相等时会停下来
             */
            do {
                ++ i;
            } while (nums[i] < pivot);
            do {
                -- j;
            } while (nums[j] > pivot);

            System.out.println("low" + "=" + left + "=" + "high" + "=" + right + "=" + "i" + "=" + i + "=" + "j" + "=" + j);


            if (i >= j)
                return j; // 用 i 也可以？ 好像不行，返回的不是选的pivot位置
            swap(nums, i, j);

            System.out.println(Arrays.toString(nums));

        }
    }

    // 要确保i != j， 或者用传统方法，用个临时变量，不用判断
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}

class MergeSort {
    // right是包含的
    public void mergesortTopDown(int[] nums, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2; // 不要(left + right) / 2， right很大时迭代到右半部分计算时会越界。
            mergesortTopDown(nums, left, middle);
            mergesortTopDown(nums, middle + 1, right);
            mergeTopDown(nums, left, right);
        }
    }

    public void mergeTopDown(int[] nums, int left, int right) {
        int[] tmp = new int[right - left + 1];
        int tmpCnt = 0;

        int middle = left + (right - left) / 2;
        int i = left, j= middle + 1;

        // 这个写法很巧妙 直接抄的
        while (i <= middle || j <= right) {
            // 左半边遍历完， 或者右半边没遍历完但是右边的小，就取右边的， 其余情况都取左边的
            if (i > middle || (j <= right && nums[i] > nums[j])) {
                tmp[tmpCnt++] = nums[j++];
            } else {
                tmp[tmpCnt++] = nums[i++];
            }
        }

        System.arraycopy(tmp, 0, nums, left, right - left + 1);
    }

/*

如果要用space的话， 调用方只能对整个数组排序，不能有left和right，否则不知道该用space的哪一部分。

https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation

用space主要是为了不用每次都申请空间，在最开始就把原始数组复制到space， merge时直接用nums在迭代时存储最终结果。

    public void mergesort(int[] nums, int left, int right) {
        if (left < right) {
            int[] space = new int[right - left + 1];
            System.arraycopy(nums, left, space, 0, right - left + 1);
            mergesort(nums, left, right, space);
        }
    }


    // right是包含的
    private void mergesort(int[] nums, int left, int right, int[] space) {
        if (left < right) {
            int middle = left + (right - left) / 2; // 不要(left + right) / 2， right很大时迭代到右半部分计算时会越界。
            mergesort(nums, left, middle, space);
            mergesort(nums, middle + 1, right, space);
            merge(nums, left, right, space);
        }
    }

    private void merge(int[] nums, int left, int right, int[] space) {
    }*/
}

