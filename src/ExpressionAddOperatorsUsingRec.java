import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperatorsUsingRec {

	List<String> result = new ArrayList<>();
	int tar;

	public List<String> addOperators(String num, int target) {
		if (num == null || num.length() == 0)
			return result;
		tar = target;
		helper(num, "", 0, 0, 0);
		return result;
	}

	private void helper(String num, String temp, long cal, long tail, int index) {
		// base
		if (index == num.length()) {
			if (cal == tar) {
				result.add(temp);
			}
			return;
		}

		// logic
		for (int i = index; i < num.length(); i++) {
			Long curr = Long.parseLong(num.substring(index, i + 1));

			if (index != i && num.charAt(index) == '0') {
				continue;
			}

			if (index == 0) {
				// for the very first value
				// recursion starts from here
				helper(num, temp + curr, curr, curr, i + 1);
			} else {
				// +
				helper(num, temp + "+" + curr, cal + curr, +curr, i + 1);
				// -
				helper(num, temp + "-" + curr, cal - curr, -curr, i + 1);

				// *
				helper(num, temp + "*" + curr, cal - tail + tail * curr, tail * curr, i + 1);

			}

		}

	}

}
