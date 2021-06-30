class Solution {
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(result, num, target, "", 0, 0, 0);
        return result;
    }

    /**
     *  result: result list to store valid expressions
     *  num: input num candidates
     *  target: input target number
     *  expr: current expression string
     *  calcVal: current calculation value
     *  preNum: previous number, in order to multiply current number if we want to put * between preNum and curNum
     *  pos: current index in the input num array
     * */
    public void dfs(List<String> result, String num, int target, String expr, long calcVal, long preNum, int pos) {
        if (pos == num.length()) {
            if (calcVal == target) {
                result.add(expr);
            }
            return;
        }

        // start from first index of current position in num string, try all possible length of nums
        for (int i = pos; i < num.length(); i++) {
            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number 
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long curNum = Long.parseLong(num.substring(pos, i + 1));

            // position 0 should be considered individually, since it does not have any operand character before curNum
            if (pos == 0) {
                dfs(result, num, target, expr + curNum, curNum, curNum, i + 1);
            }
            else {
                dfs(result, num, target, expr + "+" + curNum, calcVal + curNum, curNum, i + 1);
                dfs(result, num, target, expr + "-" + curNum, calcVal - curNum, -curNum, i + 1);
                // trick part: to calculate multiplication, we should subtract previous number, and then add current
                // multiplication result to the subtraction result 
                dfs(result, num, target, expr + "*" + curNum, calcVal - preNum + preNum * curNum, preNum * curNum, i + 1);
            }
        }
    }
}