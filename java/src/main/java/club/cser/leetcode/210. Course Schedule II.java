package club.cser.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CourseScheduleII {

    // 方法1
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0)
            return new int[0];

        Map<Integer, Integer> indegree = new HashMap<>();
        List<List<Integer>> edges = Stream.generate(ArrayList<Integer>::new)
                .limit(numCourses).collect(Collectors.toList());

        Arrays.stream(prerequisites).forEach(e -> {
            edges.get(e[1]).add(e[0]);
            if (indegree.containsKey(e[0]))
                indegree.replace(e[0], indegree.get(e[0]) + 1);
            else
                indegree.put(e[0], 1);

            indegree.computeIfAbsent(e[1], k -> 0);
        });

        int sizeOfMap = 0;

        // 随便选的课程先放进来
        List<Integer> res = IntStream.range(0, numCourses).boxed()
                .filter(i -> !indegree.containsKey(i)).collect(Collectors.toList());

        while (sizeOfMap != indegree.size()) {
            Iterator<Map.Entry<Integer, Integer>> i = indegree.entrySet().iterator();
            sizeOfMap = indegree.size();
            while (i.hasNext()) {
                Map.Entry<Integer, Integer> entry = i.next();
                if (entry.getValue() == 0) {
                    edges.get(entry.getKey()).forEach(adj -> {
                        indegree.replace(adj, indegree.get(adj) - 1);
                    });
                    res.add(entry.getKey());
                    i.remove();
                }
            }
        }

        if (indegree.size() != 0)
            res.clear();

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    // 方法2
    public int[] topologicalSortingWithDfs(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];

        List<Integer>[] graph =
                Stream.generate(ArrayList<Integer>::new).limit(numCourses).toArray(ArrayList[]::new);

        for (int[] edgs: prerequisites) {
            graph[edgs[1]].add(edgs[0]);
        }

        int[] visitedTimes = new int[numCourses];

        // Stack<Integer> res = new Stack<>();
        // 本来要用stack声明的，转成[]太麻烦了。
        List<Integer> res = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; ++ i) {
            if (visitedTimes[i] == 0)
                if (!dfs(i, graph, visitedTimes, res))
                    return new int[0];
        }

        return IntStream.range(0, numCourses).map(i -> res.get(numCourses - i - 1)).toArray();

    }

    /*
    返回true表示为无环图，false有环
     */
    boolean dfs(int currentNode, final List<Integer>[] graph, int[] visitedTimes, List<Integer> res) {

        if (visitedTimes[currentNode] == 1)
            return false;

        if (visitedTimes[currentNode] == 2)
            return true;

        visitedTimes[currentNode] = 1;

        for (int nextNode: graph[currentNode])
            if (!dfs(nextNode, graph, visitedTimes, res))
                return false;

        res.add(currentNode);

        visitedTimes[currentNode] = 2;

        return true;
    }

}
