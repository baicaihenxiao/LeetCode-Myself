package club.cser.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        if (n == 0)
            return res;


        if (n == 1 || n == 2) {
            return IntStream.range(0, n).boxed().collect(Collectors.toList());
        }

        //初始化tree
        List<Set<Integer>> tree = Stream.generate(HashSet<Integer>::new).limit(n).collect(Collectors.toList());

        //将edges转化成List<HashSet<Integer>>
        Arrays.stream(edges).forEach(e -> {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        });

//        System.out.println(tree);

        //每次去掉叶子后剩下的节点数
        int sizeOfRemainingNode = n;

        while (sizeOfRemainingNode > 2) {
            //找出所有叶子
            int[] leaf = IntStream.range(0, n).filter(i -> tree.get(i).size() == 1).toArray();
            //去掉叶子
            IntStream.of(leaf).forEach(l -> {
                //叶子的邻接节点
//                int adjacent = tree.get(l).stream().findFirst().get();
                int adjacent = tree.get(l).iterator().next();
                //去掉叶子
                tree.get(l).clear();
                //邻接节点相应地去掉
                tree.get(adjacent).remove(l);
                //去掉叶子后，其邻接节点的度数变为0，即去掉叶子后只剩下一个节点，该节点即为最长路最中间的点。
                if (tree.get(adjacent).isEmpty()) {
                    res.add(adjacent);
                }

            });
            sizeOfRemainingNode -= leaf.length;

        }

        if (!res.isEmpty())
            return res;

        //这个说明最中间的点有2个
        return IntStream.range(0, n).filter(i -> tree.get(i).size() == 1).boxed().collect(Collectors.toList());
    }
}


