//https://leetcode.com/problems/expression-add-operators/
/*
Time: O(4^N) whre N=nums.length
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(result, num, target, "", 0, 0, 0);
        return result;
    }

    public void dfs(List<String> result, String num, int target, String expr, long calcVal, long preNum, int pos) {
        if (pos == num.length()) {
            if (calcVal == target)
                result.add(expr);

            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0')
                break;

            long curNum = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0)
                dfs(result, num, target, expr + curNum, curNum, curNum, i + 1);
            else {
                dfs(result, num, target, expr + "+" + curNum, calcVal + curNum, curNum, i + 1);
                dfs(result, num, target, expr + "-" + curNum, calcVal - curNum, -curNum, i + 1);
                dfs(result, num, target, expr + "*" + curNum, calcVal - preNum + (preNum * curNum), preNum * curNum,
                        i + 1);
            }
        }
    }

}
