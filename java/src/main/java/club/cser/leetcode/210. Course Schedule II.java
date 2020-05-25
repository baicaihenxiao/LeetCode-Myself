package club.cser.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CourseScheduleII {
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
}
