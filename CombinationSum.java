/**Leetcode Question 39 - Combination Sum */
/**Algorithm - Backtracking Recursion
 * Two cases in logic: choose a number or don't choose
 * In the don't chose the index is moved to the next element and the function is called again
 * In the choose case, number is sub from target and the index remain same.
 * Check the base case - index should not be greater then the length of the candidates array and the target <0
 * If target is zero, append the path to the result and return to avoid duplicate combinations
 */
/**TC - 2^N  
 * SC - O(N)
 */
public class CombinationSum {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if(candidates == null || candidates.length == 0){
                return result;
            }
            backtrack(candidates, target, 0, new ArrayList<>());
            return result;
        }
        private void backtrack(int[] candidates, int target, int index, List<Integer> path){
            //base
            if(target < 0 || index == candidates.length){
                return;
            }
            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            //logic
            backtrack(candidates, target, index+1, path);
            path.add(candidates[index]);
            backtrack(candidates, target - candidates[index], index, path);
            path.remove(path.size() -1);
        }
    }
}
/**Iterative Solution */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        //List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index; i< candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
