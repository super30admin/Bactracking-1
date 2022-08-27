import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n*n!) where n = length of num
// Space Complexity : O(n) where n = length of num
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//282. Expression Add Operators (Hard) - https://leetcode.com/problems/expression-add-operators/
class Solution {

	List<String> result;

	public List<String> addOperators(String num, int target) {
		result = new ArrayList<>();
		//helper(num, 0, 0, 0, "", target);
		backtrack(num, 0, 0, 0, new StringBuilder(), target);
		return result;
	}

//	private void helper(String num, int pivot, long calculatedValue, long tail, String path, int target) {
//		// base
//		if (pivot == num.length()) {
//			if (calculatedValue == target) {
//				result.add(path);
//			}
//			return;
//		}
//		// logic
//		for (int i = pivot; i < num.length(); i++) {
//			// preceeding zero case
//			if (num.charAt(pivot) == '0' && i != pivot)
//				continue; // 05 gets converted to 5 when parsed, so we need to skip 0 when pivot character
//							// is zero and index is not equal to pivot
//
//			long curr = Long.parseLong(num.substring(pivot, i + 1));
//
//			if (pivot == 0) {
//				helper(num, i + 1, curr, curr, path + curr, target);
//			} else {
//				// +
//				helper(num, i + 1, calculatedValue + curr, +curr, path + "+" + curr, target);
//
//				// -
//				helper(num, i + 1, calculatedValue - curr, -curr, path + "-" + curr, target);
//
//				// *
//				helper(num, i + 1, calculatedValue - tail + (tail * curr), tail * curr, path + "*" + curr, target);
//			}
//		}
//	}
	
	private void backtrack(String num, int pivot, long calculatedValue, long tail, StringBuilder path, int target) { // O(n) stack space where n = length of num
        // base
        if (pivot == num.length()) {
            if (calculatedValue == target) {
                result.add(path.toString());
            }
            return;
        }
        // logic
        for (int i = pivot; i < num.length(); i++) {
            // preceeding zero case
            if (num.charAt(pivot) == '0' && i != pivot) continue; // 05 gets converted to 5 when parsed, so we need to skip 0 when pivot character is zero and index is not equal to pivot
            
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int length = path.length();
            
            if (pivot == 0) {
                // action
                path.append(curr);
                
                // recurse
                backtrack(num, i+1, curr, curr, path, target);
                
                // backtrack
                path.setLength(length);
            } else {
                // case "+"
                // action
                path.append("+").append(curr);
                
                // recurse
                backtrack(num, i+1, calculatedValue + curr, +curr, path, target);
                
                // backtrack
                path.setLength(length);
                
                // case "-"
                // action
                path.append("-").append(curr);
                
                // recurse
                backtrack(num, i+1, calculatedValue - curr, -curr, path, target);
                
                // backtrack
                path.setLength(length);
                
                // case "*"
                // action
                path.append("*").append(curr);
                
                // recurse
                backtrack(num, i+1, calculatedValue - tail + (tail * curr), tail * curr, path, target);
                
                // backtrack
                path.setLength(length);
            }
        }
    }
}