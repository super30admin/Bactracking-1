
// approch 1 
// Time Complexity : O(n^2 * 4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no\

// approch 2
// Time Complexity : O(n * 4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    private static List<String> result;

    // approch 1 using string to store path (brute force)
    public static List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(0, num, 0, 0, "", target);
        return result;

    }

    private static void helper(int idx, String num, long curNum, long tail, String path, int target) {
        // base case
        if (idx == num.length()) {
            // if curNum is eqaul to target we path into result
            if (curNum == target) {
                result.add(path);
            }
            return;
        }

        // main logic
        // for loop based recursion
        for (int i = idx; i < num.length(); i++) {
            // zero case
            // here we check if any number has preceding zero we are ignoring this as it
            // will give wrong ans
            if (idx != i && num.charAt(idx) == '0')
                continue;

            // further we take substring from idx to i+1 and convert it into long it is our
            // current number to add substract ot multiply
            long cur = Long.parseLong(num.substring(idx, i + 1));
            // here further we have to options if idx == 0 that means there is no precedence
            // sign so we directly add it to the path else we perform diffrent operations on
            // it
            if (idx == 0) {
                helper(i + 1, num, cur, cur, path + cur, target);
            } else {
                // +
                helper(i + 1, num, curNum + cur, cur, path + "+" + cur, target);
                // -
                helper(i + 1, num, curNum - cur, -cur, path + "+" + cur, target);
                // *
                helper(i + 1, num, curNum - tail + cur * tail, cur * tail, path + "*" + cur, target);

            }

        }
    }

    // approch 2 using stringBuilder to add path

    // approch 1 using string to store path (brute force)
    public static List<String> addOperators2(String num, int target) {
        result = new ArrayList<>();
        backtrack(0, num, 0, 0, new StringBuilder(), target);
        return result;
    }

    private static void backtrack(int idx, String num, long curNum, long tail, StringBuilder path, int target) {
        // base case
        if (idx == num.length()) {
            // if curNum is eqaul to target we path into result
            if (curNum == target) {
                result.add(new String(path));
            }
            return;
        }
        // main logic
        // for loop based recursion
        for (int i = idx; i < num.length(); i++) {
            // zero case
            // here we check if any number has preceding zero we are ignoring this as it
            // will give wrong ans
            if (idx != i && num.charAt(idx) == '0')
                continue;
            // further we take substring from idx to i+1 and convert it into long it is our
            // current number to add substract ot multiply
            long cur = Long.parseLong(num.substring(idx, i + 1));
            // length of the path as we want to reset it to previos one after recursion
            int le = path.length();

            // here further we have to options if idx == 0 that means there is no precedence
            // sign so we directly add it to the path else we perform diffrent operations on
            // it
            if (idx == 0) {
                // action
                path.append(cur);
                // recurse
                backtrack(i + 1, num, cur, cur, path, target);
                // backtrack
                path.setLength(le);
            } else {
                // +
                // action
                path.append("+");
                path.append(cur);
                // recurse
                backtrack(i + 1, num, curNum + cur, cur, path, target);
                // backtrack
                path.setLength(le);
                // -
                // action
                path.append("-");
                path.append(cur);
                // recurse
                backtrack(i + 1, num, curNum - cur, -cur, path, target);
                // backtrack
                path.setLength(le);
                // *
                // action
                path.append("*");
                path.append(cur);
                // recurse
                backtrack(i + 1, num, curNum - tail + cur * tail, cur * tail, path, target);
                // backtrack
                path.setLength(le);
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
        System.out.println(addOperators2(num, target));

    }
}