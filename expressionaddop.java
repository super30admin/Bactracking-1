//Time Complexity: O(4^n)
//Space Complexity: O(N)
//Tried on leetcode and accepted
//Problems Faced: Was not clear about back tracking previously before class so could not complete the code
//Once I attended the class was clear on the intution. 
/**
 * When we use dfs to do this question, the most tricky part is that how to deal with multiplication. For every 
 * addition and subtraction, we just directly adding or subtracting the new number. However, for multiplication, 
 * we should multiply current number and previous number firstly, and then add previous previous number.
 * So we can use a variable preNum to record every previous number in each recursion step. If current recursive 
 * call is trying multiplication, we should use previous calculation value subtract previous number, and then 
 * adding multiplication result between previous number and current number.
 * */
public List<String> addOperators(String num, int target) {
    if (num.length() == 0) {
        return new ArrayList<>();
    }

    List<String> result = new ArrayList<>();
    dfs(result, num, target, "", 0, 0, 0);
    return result;
}

/**
 * result: result list to store valid expressions
 * num: input num candidates
 * target: input target number
 * expr: current expression string
 * calcVal: current calculation value
 * preNum: previous number, in order to multiply current number if we want to put * between preNum and curNum
 * pos: current index in the input num array
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