// Time Complexity : O(1) // For each operation
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class Problem2 {
public List<String> addOperators(String num, int target) {
	List<String> result = new ArrayList<String>();
	addOperators(num, target, 0, result, "", 0, 0);
	return result;
}

private void addOperators(String num, int target, int start, List<String> result, String expression, long valueYet, long previousNumber) {
	if (start == num.length() && valueYet == target)
		result.add(expression);
	else
		// for each choice
		for (var i = start; i < num.length(); i++) {
			if (i != start && num.charAt(start) == '0')
				break;
			var current = Long.parseLong(num.substring(start, i + 1));

			// choose-explore-unchoose
			if (start == 0) {
				addOperators(num, target, i + 1, result, expression + current, current, current);
			} else {
				addOperators(num, target, i + 1, result, expression + "+" + current, valueYet + current, current);
				addOperators(num, target, i + 1, result, expression + "-" + current, valueYet - current, -current);

				var newValue = (valueYet - previousNumber) + (previousNumber * current);
				addOperators(num, target, i + 1, result, expression + "*" + current, newValue, previousNumber * current);
			}
		}
	}
}
