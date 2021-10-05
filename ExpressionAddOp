class Solution {
    public List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        backtracking(num, 0, target, "", 0, 0);
        return res;
    }
    
    public void backtracking(String num, int ind, long target, String temp, long tot, long pre) {
        if (ind == num.length() && tot == target) {
            res.add(temp);
            return;
        }
        long cur = 0;
        for (int end = ind; end < num.length(); end++) {
            if (end > ind && num.charAt(ind) == '0') return;
            cur = cur * 10 + num.charAt(end) - '0';
            String sub = num.substring(ind, end + 1);
            if (ind == 0) {
                backtracking(num, end + 1, target, sub, cur, cur);
                continue;
            }
            backtracking(num, end + 1, target, temp + "+" + sub, tot + cur, cur);
            backtracking(num, end + 1, target, temp + "-" + sub, tot - cur, -cur);
            backtracking(num, end + 1, target, temp + "*" + sub, tot + (cur - 1) * pre, cur * pre);
        }
    }
}