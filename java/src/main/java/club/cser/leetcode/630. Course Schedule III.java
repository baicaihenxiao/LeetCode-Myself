package club.cser.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        //默认是小根堆，要用大根堆(最大堆)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int curDays = 0;

        for (int[] c: courses) {
            maxHeap.offer(c[0]);
            curDays += c[0];
            if (curDays > c[1]) {
                curDays -= maxHeap.poll();
            }
        }

        return maxHeap.size();

    }


/*    public int scheduleCourse(int[][] courses) {

        courses = Arrays.stream(courses).filter(c -> c[0] <= c[1]).sorted(Comparator.comparing(c -> c[1])).toArray(int[][]::new);
        Arrays.stream(courses).map(Arrays::toString).forEach(System.out::println);

        int[] res = {0, 0};
        Stack<Integer> s = new Stack<>();
        s.push(0);

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        Arrays.stream(courses).filter(c -> c[0] <= c[1])
                .sorted(Comparator.comparing(c -> c[1]))
                .reduce(res, (pre, next) -> {

                    if (next[0] > s.peek()) {
                        while ()
                    }

                    if (pre[0] + next[0] <= next[1]) {
                        pre[0] = pre[0] + next[0];
                        ++ pre[1];
                        s.push(1);
                    }
                    return pre;
                });

        return res[1];
    }*/

/*    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        int time=0;
        for (int[] c:courses)
        {
            time+=c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }*/

}