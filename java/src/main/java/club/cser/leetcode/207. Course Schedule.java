package club.cser.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1)
            return true;

        Map<Integer, Integer> indegree = new HashMap<>();
        // List<List<Integer>> edges = new ArrayList<>(Collections.nCopies(numCourses, new ArrayList<>())); 这样不行，修改一个list会影响其它list。
        List<List<Integer>> edges = Stream.generate(ArrayList<Integer>::new).limit(numCourses).collect(Collectors.toList());

        Arrays.stream(prerequisites).forEach(e -> {
            edges.get(e[1]).add(e[0]);
            if (indegree.containsKey(e[0]))
                indegree.replace(e[0], indegree.get(e[0]) + 1);
            else
                indegree.put(e[0], 1);

            indegree.computeIfAbsent(e[1], k -> 0);
        });

//        System.out.println(indegree);

        int sizeOfMap = 0;

        while (sizeOfMap != indegree.size()) {
            Iterator<Map.Entry<Integer, Integer>> i = indegree.entrySet().iterator();
            sizeOfMap = indegree.size();
            while (i.hasNext()) {
                Map.Entry<Integer, Integer> entry = i.next();
                if (entry.getValue() == 0) {
                    edges.get(entry.getKey()).forEach(adj -> {
                        indegree.replace(adj, indegree.get(adj) - 1);
                    });
                    i.remove();
                }
            }
        }

        return indegree.size() == 0;
    }


}