package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExpressionAddOperators {

    /**
     * 输入和输出不想写在dfs参数列表里，参数太多了。
     */
    private long target;
    private String num;
    private List<String> res;

    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        this.target = target;
        this.num = num;
        dfs(0, 0, 0, new StringBuilder(""));

        return res;
    }

    /**
     *
     * dfs遍历所有的情况
     *
     * @param index 迭代到字符串num的哪个下标
     * @param preOperand 上一个操作数
     * @param preEval 已经计算出的表达式(即expression)的结果
     * @param expression 前面字符串已经构成的表达式
     */
    private void dfs(int index, long preOperand, long preEval, StringBuilder expression) {

        if (index == num.length()) {
            if (preEval == this.target)
                res.add(expression.toString());
            return;
        }

        // 取出以index开始的所有可能的操作数
        for (int i = index; i < num.length(); i++) {
            String curOperandStr = num.substring(index, i + 1);
            // 要用parseLong，int可能越界
            long curOperand = Long.parseLong(curOperandStr); // System.out.printf("" + Integer.parseInt("02")); 会输出2不会报错

            if (index != 0) {
                dfs(i + 1, curOperand, preEval + curOperand, new StringBuilder(expression).append('+').append(curOperandStr));
                dfs(i + 1, -curOperand, preEval - curOperand, new StringBuilder(expression).append('-').append(curOperandStr));
                dfs(i + 1, preOperand * curOperand, preEval - preOperand + preOperand * curOperand, new StringBuilder(expression).append('*').append(curOperandStr));
            } else {
                // index == 0， 即此时为字符串num的首个字符，特殊处理，因为前面不能加符号。
                dfs(i + 1, curOperand, curOperand, new StringBuilder(expression).append(curOperandStr));
            }

            // 排除掉以0开始的数的情况 比如 4+02
            if (num.charAt(index) == '0')
                break;
        }

    }

}
