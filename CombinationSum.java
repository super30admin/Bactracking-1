/**
 * Time Complexity: O(2 ^ N)??
 * Space Complexity: O(n)
 * Runs on Leetcode: yes
 * Problems Solving: 
 */
class Solution {
    List<List<Integer>> solution;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solution = new ArrayList<>();
        backtrack(candidates, 0, target, 0, new ArrayList<>());
        return solution;
    }
    
    private void backtrack(int[] nums, int index, int target, int sum, List<Integer> values){
        //base case 
        if(sum == target){
            solution.add(new ArrayList<>(values));
            return;
        }
        if(sum > target) return; 
        for(int i = index; i < nums.length; i++){
            values.add(nums[i]);
            sum+= nums[i];
            backtrack(nums, i, target, sum, values);
            sum -= nums[i];
            values.remove(values.size() - 1);
        }
    }
}
