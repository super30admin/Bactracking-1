class Solution {
    // Time Complexity : O(4^n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - for loop recursion
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return res;
    }


    public void helper(String num, int target, long calc, long tail, int index, String path) {
        if(index == num.length()) {
            if(calc == target) {
                res.add(path);
                return;
            }
        }

        for(int i = index; i < num.length(); i++) {
            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0) {
                helper(num, target, curr, curr, i+1, path + curr);
            } else {
                helper(num, target, calc + curr, curr, i+1, path + "+" + curr);

                helper(num, target, calc - curr, -curr, i+1, path + "-" + curr);

                helper(num, target, calc - tail + (tail*curr), tail*curr, i+1, path + "*" + curr);
            }
        }
    }
}


// Time Complexity : O(n * 4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - for loop recursion with backtracking
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return res;
    }


    public void helper(String num, int target, long calc, long tail, int index, StringBuilder path) {
        if(index == num.length()) {
            if(calc == target) {
                res.add(path.toString());
                return;
            }
        }

        for(int i = index; i < num.length(); i++) {
            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = path.length();
            if(index == 0) {
                path.append(curr);
                helper(num, target, curr, curr, i+1, path);
                path.setLength(len);
            } else {
                path.append("+");
                path.append(curr);
                helper(num, target, calc + curr, curr, i+1, path);
                path.setLength(len);

                path.append("-");
                path.append(curr);
                helper(num, target, calc - curr, -curr, i+1, path);
                path.setLength(len);

                path.append("*");
                path.append(curr);
                helper(num, target, calc - tail + (tail*curr), tail*curr, i+1, path);
                path.setLength(len);
            }
        }
    }
}