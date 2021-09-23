// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class expressionAddOps {
    public List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        backtracking(num, 0, target, "", 0, 0);
        return result;
    }
    
    private void backtracking(String num, int index, long target, String temp, long tot, long pre) {
        if (index == num.length() && tot == target) {
            result.add(temp);
            return;
        }
        long cur = 0;
        for (int end = index; end < num.length(); end++) {
            if (end > index && num.charAt(index) == '0') return;
            cur = cur * 10 + num.charAt(end) - '0';
            String sub = num.substring(index, end + 1);
            if (index == 0) {
                backtracking(num, end + 1, target, sub, cur, cur);
                continue;
            }
            backtracking(num, end + 1, target, temp + "+" + sub, tot + cur, cur);
            backtracking(num, end + 1, target, temp + "-" + sub, tot - cur, -cur);
            backtracking(num, end + 1, target, temp + "*" + sub, tot + (cur - 1) * pre, cur * pre);
        }
    }
}
