// Time Complexity :O(N^N * N)
//O(N^N) for generating N nodes for each character in the recursion tree.
//O(N) for traversing the entire string.

// Space Complexity :O(M) where M is the length of the recursion stack 

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Bactracking follows brute force approach. So we traverse the entire string and check for each possible operation 
//that could reach the target.
import java.util.*;

public class ExpressionOperator {
    public List<String> output = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        backtracking(num, target, 0, 0, 0, "");
        return output;

    }

    public void backtracking(String num, int target, int index, long prevSum, long prevAdd, String expr) {
        if (index >= num.length()) {
            if (prevSum == target) {
                output.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(index, i + 1));

            if (num.charAt(index) == '0' && index != i)
                continue;
            if (index == 0) {
                backtracking(num, target, i + 1, curr, curr, expr + curr);
            } else {
                // +
                backtracking(num, target, i + 1, prevSum + curr, curr, expr + '+' + curr);

                // -
                backtracking(num, target, i + 1, prevSum - curr, -curr, expr + '-' + curr);

                // *
                backtracking(num, target, i + 1, prevSum - prevAdd + prevAdd * curr, prevAdd * curr, expr + '*' + curr);

            }
        }
    }

    public static void main(String args[]) {
        ExpressionOperator obj = new ExpressionOperator();
        String num = "123";
        int target = 6;
        System.out.println(obj.addOperators(num, target));
    }
}
