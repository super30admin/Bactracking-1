package Backtracking_1;

import java.util.ArrayList;
import java.util.List;
/**
 * Using backtracking in for loop based recursion to generate all the number combinations and for ech combination we are trying out each of the expressions (+,-,*).
 * 
 * Time Complexity :
 * O(2^(n)*3^(n))- where n is the no of digits given.
 * 
 * Space Complexity :
 * O(n), space for the recursive stack
 * O(n) space for the Stringbuilder used for backtracking.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {

	StringBuilder path = new StringBuilder();
	int strLength;
	int Target;
	String[] expr = { "+", "-", "*" };
	List<String> expressions = new ArrayList<>();

	public List<String> addOperators(String num, int target) {
		strLength = num.length();
		Target = target;
		helper(num, 0, 0);
		return expressions;
	}

	void helper(String num, long calc, long tail) {
		if (num.length() == 0) {
			if (calc == Target)
				expressions.add(path.toString());
			return;
		}

		for (int i = 0; i < num.length(); i++) {
			String curr = num.substring(0, i + 1);
			if (curr.charAt(0) == '0' && curr.length() > 1)
				return;
			Long currNum = Long.parseLong(curr);

			if (num.length() == strLength) {
				int length = path.length();
				path = path.append(curr);
				helper(num.substring(i + 1, num.length()), currNum, currNum);
				path.setLength(length);
			} else {
				for (int j = 0; j < 3; j++) {

					int length = path.length();
					path = path.append(expr[j]);
					path = path.append(curr);
					if (j == 0)
						helper(num.substring(i + 1, num.length()), calc + currNum, currNum);
					else if (j == 1)
						helper(num.substring(i + 1, num.length()), calc - currNum, -currNum);
					else
						helper(num.substring(i + 1, num.length()), calc - tail + tail * currNum, tail * currNum);
					path.setLength(length);
				}
			}

		}
	}

}
