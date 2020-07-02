// Time Complexity :O(2^n) 
// Space Complexity :O(n*2^n) 
// Did this code successfully run on Leetcode :yes

/**
 * 
 * https://leetcode.com/problems/expression-add-operators/
 *
 */
public class ExpressionAddOperators {
	List<String> res;
	int tar;
	public List<String> addOperators(String num, int target) {
		res = new ArrayList<>();
		tar = target;

		if(num == null || num.length() == 0) return res;

		helper(num, "" , 0, 0, 0);

		return res;
	}

	private void helper(String num, String path, long currCalVal, long tail, int index){

		//base
		if(index == num.length()) {
			if(currCalVal == tar) {
				res.add(path);
			}
			return;
		}

		for(int i=index; i< num.length(); i++) {
			//handle preceding zero
			if(num.charAt(i) == '0' && i != index) break;

			//case 4 when we do not choose +,-,*
			long curr = Long.parseLong(num.substring(index, i+1));

			if(index == 0) {
				helper(num, path+curr, curr, curr, i+1);
			}else {
				//case 1 for +
				helper(num, path+ "+" + curr , currCalVal + curr, curr, i+1);

				//case 2 for -
				helper(num, path+ "-" + curr , currCalVal - curr, -curr, i+1);

				//case 3 for *
				helper(num, path + "*" + curr , (currCalVal - tail) + tail * curr, tail * curr, i+1);
			}


		}
	}
}
