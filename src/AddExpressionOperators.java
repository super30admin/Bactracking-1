import java.util.ArrayList;
import java.util.List;
//Time Complexity : No idea
//Space Complexity : No Idea
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Used the solution from discussion forum. If more than 1 0 is present, and 0
 * is the 1st number in forming the number, then break out of the loop. Else,
 * start iterating over all the indices of the string. For 0th index, just push
 * the 1st number to the result path. For rest of the cases add the operator and
 * then the string, and update the current sum and previous as the current value
 * obtained. for multiplication we have to delete the prev out of current total
 * sum and then multiply with the prev to get the correct result.
 *
 */
class Solution {
	List<String> ans = new ArrayList<>();

	public List<String> addOperators(String num, int target) {
		helper(num, target, 0, "", 0, 0);
		return ans;
	}

	public void helper(String num, int target, int start, String sb, long curr, long prev) {
		if (start == num.length() && curr == target) {
			ans.add(sb.toString());
			return;
		}

		for (int i = start; i < num.length(); i++) {
			// when two consecutive 0s are present, we have to break the loop.
			if (i != start && num.charAt(start) == '0')
				break;

			long temp = Long.parseLong(num.substring(start, i + 1));
			if (start == 0) {
				helper(num, target, i + 1, sb + (temp), temp, temp);
			} else {
				helper(num, target, i + 1, sb + ("+") + (temp), curr + temp, temp);
				helper(num, target, i + 1, sb + ("-") + (temp), curr - temp, -temp);
				var multi = (curr - prev) + (prev * temp);
				helper(num, target, i + 1, sb + ("*") + (temp), multi, temp * prev);
			}
		}
	}
}