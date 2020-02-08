import java.util.ArrayList;
import java.util.List;

public class AddOperator {
	List<String> result = new ArrayList<>();

	public List<String> addOperators(String num, int target) {
		if (num == null || num.length() == 0)
			return result;
		backtrack("", num, target, 0, 0, 0);
		return result;
	}

	private void backtrack(String path, String num, int target, long calculated, long tail, int index) {
		if (index == num.length()) {
			if (calculated == target) {
				result.add(path);
				return;
			}
		}

		for (int i = index; i < num.length(); i++) {
			if (i != index && num.charAt(index) == '0')
				break;
			long curr = Long.parseLong(num.substring(index, i + 1));
			if (index == 0) {
				backtrack(path + curr, num, target, curr, curr, i + 1);
			} else {
				backtrack(path + '+' + curr, num, target, calculated + curr, curr, i + 1);
				backtrack(path + '-' + curr, num, target, calculated - curr, -curr, i + 1);
				backtrack(path + '*' + curr, num, target, calculated - tail + tail * curr, tail * curr, i + 1);
			}
		}
	}
}
