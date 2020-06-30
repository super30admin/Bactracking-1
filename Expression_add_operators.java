
// Time Complexity : O(4^N)
// Space Complexity : Having trouble to figure out space complexity
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : doubt in Space Complexity
import java.util.*;

public class Expression_add_operators {
	List<String> result;
	int tar;

	public List<String> addOperators(String num, int target) {
		result = new ArrayList<>();
		tar = target;
		helper(num, "", 0, 0, 0);
		return result;
	}

	private void helper(String num, String path, long calc, long tail, int index) {
		// base
		if (index == num.length()) {
			if (tar == calc) {
				result.add(path);
			}
			return;
		}
		// logic
		for (int i = index; i < num.length(); i++) {
			if (num.charAt(index) == '0' && index != i)
				break;
			long curr = Long.parseLong(num.substring(index, i + 1));
			if (index == 0) {
				helper(num, path + curr, curr, curr, i + 1);
			} else {
				// +
				helper(num, path + "+" + curr, calc + curr, curr, i + 1);
				// -
				helper(num, path + "-" + curr, calc - curr, -curr, i + 1);
				// *
				helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);
			}
		}

	}
}