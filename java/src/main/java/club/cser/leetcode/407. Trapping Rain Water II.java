package club.cser.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

class TrappingRainWaterII {

    private class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        final int ROWS = heightMap.length;
        final int COLS = heightMap[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        // 最小堆，墙的高度从低到高
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // 将四周加入到堆里，并且设置为已访问。
        for (int i = 0; i < ROWS; i++) {
            visited[i][0] = true;
            visited[i][COLS - 1] = true;
            minHeap.add(new Cell(i, 0, heightMap[i][0]));
            minHeap.add(new Cell(i, COLS - 1, heightMap[i][COLS - 1]));
        }
        for (int i = 0; i < COLS; i++) {
            visited[0][i] = true;
            visited[ROWS - 1][i] = true;
            minHeap.add(new Cell(0, i, heightMap[0][i]));
            minHeap.add(new Cell(ROWS - 1, i, heightMap[ROWS - 1][i]));
        }

        int res = 0;

        // BFS上下左右
        final int[][] neighbors = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!minHeap.isEmpty()) {
            // 当前墙的高度
            int tmpWall = minHeap.peek().height;
            while (minHeap.peek() != null && minHeap.peek().height <= tmpWall) {
                Cell tmpCell = minHeap.poll();
                // BFS上下左右
                for (int i = 0; i < 4; i++) {
                    int tmpRow = tmpCell.row + neighbors[i][0];
                    int tmpCol = tmpCell.col + neighbors[i][1];
                    // 判断上下左右是否在范围内，因为最外面一层肯定没用，所以判断条件随便写
                    if (tmpRow > 0 && tmpRow < ROWS && tmpCol > 0 && tmpCol < COLS && !visited[tmpRow][tmpCol]) {
                        visited[tmpRow][tmpCol] = true;
                        minHeap.add(new Cell(tmpRow, tmpCol, heightMap[tmpRow][tmpCol]));
                        res += Math.max(0, tmpWall - heightMap[tmpRow][tmpCol]); // 如果比墙矮，则可以存水。
                    }
                }
            }
        }

        return res;
    }


    /**
     * 错误思路：
     * 这个思路是像42题那样，找到上下左右四方最矮的墙，用墙的高度-该处柱子 即为该处蓄水的大小。
     * 例如：
     * 12,13,1,12
     * 13,4,13,12
     * 13,8,10,12
     * 12,13,12,12
     * 数字4的墙是多少？按照这种做法是13，因为上下左右墙均为13，但是实际上墙应该是12，即10的右边和下边为12.
     *    13
     * 13, 4, 13
     * 13, 8, 10, 12
     *    13, 12
     *
     * @param heightMap
     * @return
     */
    public int trapRainWaterERROR(int[][] heightMap) {
        int[][] minWall = Arrays.stream(heightMap).map((int[] row) -> new int[row.length]).toArray(int[][]::new);
        int res = 0;
        for (int i = 0; i < heightMap.length; i++) {
            int tmpMax = 0;
            for (int j = 0; j < heightMap[i].length; j++) {
                minWall[i][j] = tmpMax;
                tmpMax = Math.max(tmpMax, heightMap[i][j]);
            }
            tmpMax = 0;
            for (int j = heightMap[i].length - 1; j >= 0; j --) {
                minWall[i][j] = Math.min(tmpMax, minWall[i][j]);
                tmpMax = Math.max(tmpMax, heightMap[i][j]);
            }
        }
        for (int j = 0; j < heightMap[0].length; j++) {
            int tmpMax = 0;
            for (int i = 0; i < heightMap.length; i++) {
                minWall[i][j] = Math.min(tmpMax, minWall[i][j]);
                tmpMax = Math.max(tmpMax, heightMap[i][j]);
            }
            tmpMax = 0;
            for (int i = heightMap.length - 1; i >= 0; i --) {
                minWall[i][j] = Math.min(tmpMax, minWall[i][j]);
                if (minWall[i][j] > heightMap[i][j]) {
                    res += minWall[i][j] - heightMap[i][j];
                    System.out.printf("di %d %d , 高度=%d, 墙=%d, 水=%d, 结果=%d \n",i, j, heightMap[i][j], minWall[i][j], minWall[i][j] - heightMap[i][j], res);
                }
                tmpMax = Math.max(tmpMax, heightMap[i][j]);

            }

        }
        return res;
    }
}