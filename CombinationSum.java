/*Time Complexity: O(2^n)
Space Complexity: O(2^n) (including the recursive stack)
Pick the first element and choose it multiple times until the sum reaches the target value. if sum == target, then its a valid combination and add to the result.
Call backtrack recursively, where we remove the last added element if the sum exceeds the target value(backtracking step).
*/

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> temp, int sum, int index){
        if(sum > target) return;
        if(sum == target)
            result.add(new ArrayList<>(temp));//
        else{
            for(int i=index; i<candidates.length; i++){
                if(candidates[i] <= target){
                    temp.add(candidates[i]);
                    backtrack(candidates, target, temp, sum + candidates[i], i);
                    temp.remove(temp.size() - 1);//backtracking step here when the recursion starts coming back 
                }
            }
        }
    }
}
