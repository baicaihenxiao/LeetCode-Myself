package club.cser.leetcode;

class UniqueBinarySearchTrees {
    public int numTrees(int n) {

        int[] subtrees = new int[n + 1];

        subtrees[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                subtrees[i] += subtrees[j] * subtrees[i - j - 1];
            }
        }

/*
这个可以不用    subtrees[0] = 1;
for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                subtrees[i] += Math.max(subtrees[j], 1) * Math.max(subtrees[i - j - 1], 1);
            }
        }*/
        return subtrees[n];
    }
}