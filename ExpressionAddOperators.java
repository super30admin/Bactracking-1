// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We use the iterative recursion as our approach
// we write the recursion for the same and put the four possible cases
// We take calculated value, tail to help us

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    public void helper(String num, int target, int index, long calc, long tail, String path) {
        if (index == num.length())
            if (calc == target) {
                result.add(path);
                return;
            }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                helper(num, target, i + 1, calc - tail + (curr * tail), curr * tail, path + "*" + curr);
            }
        }
    }
}

// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We use the iterative recursion as our approach
// we write the recursion for the same and put the four possible cases
// We take calculated value, tail to help us
// we expand on it by doing the backtracking i.e remove the element that doesnt
// give the answer

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    public void helper(String num, int target, int index, long calc, long tail, StringBuilder sb) {
        if (index == num.length())
            if (calc == target) {
                result.add(sb.toString());
                return;
            }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                continue;
            Long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();
            if (index == 0) {
                sb.append(curr);
                helper(num, target, i + 1, curr, curr, sb);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(curr);
                helper(num, target, i + 1, calc + curr, curr, sb);
                sb.setLength(len);
                sb.append("-");
                sb.append(curr);
                helper(num, target, i + 1, calc - curr, -curr, sb);
                sb.setLength(len);
                sb.append("*");
                sb.append(curr);
                helper(num, target, i + 1, calc - tail + (curr * tail), curr * tail, sb);
                sb.setLength(len);
            }
        }
    }
}