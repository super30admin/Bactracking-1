//Time Complexity : O(n*(4^n)), n -> Size of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	List<String> ans;

	public List<String> addOperators(String num, int target) {
		ans = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return ans;
		}

		helper(num, target, 0, 0, 0, new StringBuilder());
		return ans;
	}

	public void helper(String num, int target, int index, long calc, long tail, StringBuilder expression) {
		// Base
		if (index == num.length()) {
			if (calc == target) {
				ans.add(expression.toString());
			}
			return;
		}
		// Logic
		for (int i = index; i < num.length(); i++) {
			if (num.charAt(index) == '0' && i != index) {
				return;
			}

			long curr = Long.parseLong(num.substring(index, i + 1));
			int len = expression.length();
			if (index == 0) {
				expression.append(curr);
				helper(num, target, i + 1, curr, curr, expression);
				expression.setLength(len);
			} else {
				// Addition
				expression.append("+");
				expression.append(curr);
				helper(num, target, i + 1, calc + curr, curr, expression);
				expression.setLength(len);
				// Subtraction
				expression.append("-");
				expression.append(curr);
				helper(num, target, i + 1, calc - curr, -curr, expression);
				expression.setLength(len);
				// Multiplication
				expression.append("*");
				expression.append(curr);
				helper(num, target, i + 1, calc - tail + (tail * curr), tail * curr, expression);
				expression.setLength(len);
			}
		}
	}

	public static void main(String[] args) {
		ExpressionAddOperators obj = new ExpressionAddOperators();
		String num = "123";
		int target = 6;
		List<String> ans = obj.addOperators(num, target);

		System.out.println("Set of expressions that evaluate to the target \'" + target + "\'");
		for (String str : ans) {
			System.out.println(str);
		}
		System.out.println();
	}

}
