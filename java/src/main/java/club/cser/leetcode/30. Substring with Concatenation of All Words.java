package club.cser.leetcode;

import java.util.*;
import java.util.stream.Collectors;

class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0)
            return res;
        int wordLength = words[0].length();
        int allWordsLength = wordLength * words.length;
        Map<String, Integer> wordsMap = Arrays.stream(words).collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));

        for (int i = 0; i <= s.length() - allWordsLength; i++) {
            Map<String, Integer> tmpMap = new HashMap<>(wordsMap);
            for (int j = i; j < allWordsLength + i; j += wordLength) {
                String curWord = s.substring(j, j + wordLength);
                if (!tmpMap.containsKey(curWord))
                    break;
                tmpMap.compute(curWord, (k, v) -> v - 1);
//                System.out.println(String.format("%d %d %s %d", i, j, curWord, tmpMap.get(curWord)));
                if (tmpMap.get(curWord) == 0)
                    tmpMap.remove(curWord);
            }
            if (tmpMap.isEmpty())
                res.add(i);
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0)
            return res;
        int wordLength = words[0].length();
        int allWordsLength = wordLength * words.length;
        Map<String, Integer> wordsMap = Arrays.stream(words).collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> tmpMap = new HashMap<>(wordsMap);
            Queue<String> queue = new LinkedList<>();
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
//                if (j + allWordsLength > s.length())
//                    break;
                String curWord = s.substring(j, j + wordLength);
                if (!tmpMap.containsKey(curWord)) {
                    queue.clear();
                    tmpMap = new HashMap<>(wordsMap);
                    continue;
                }
                if (tmpMap.get(curWord) == 0) {
                    while (!queue.peek().equals(curWord)) {
                        tmpMap.compute(queue.poll(), (k, v) -> v + 1);
                    }
                    queue.poll();
                    queue.offer(curWord);
                    continue;
                }

                tmpMap.compute(curWord, (k, v) -> v - 1);
                queue.offer(curWord);

                if (tmpMap.get(curWord) == 0) {
                    if (queue.size() == words.length) {
                        res.add(j + wordLength - allWordsLength);
                        tmpMap.compute(queue.poll(), (k, v) -> v + 1);
                    }
                }
            }

        }
        return res;
    }


}