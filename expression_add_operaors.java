/*

// Recursive solution
Time Complexity: O(2^N)
Space Complexity: O(N * 2^N)

class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result = new ArrayList<>();
        if(candidates.length ==0 || candidates == null)
            return result;
        helper(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    private void helper(int[]candidates, List<Integer> temp, int index, int sum){
        //base case
        if(sum == targ){
            result.add(temp);
            return;
        }
        if(sum > targ || index == candidates.length)
            return;
        //logic
        //don't choose a coin
        helper(candidates, new ArrayList<>(temp), index + 1, sum);
        // choose a coin
        temp.add(candidates[index]);
        helper(candidates, new ArrayList<>(temp), index, sum + candidates[index]);
    }
}
*/


// Backtracking solution: 
//Time Complexity: O(2 ^ N)
// Space Complexity: O(N)
//where N is the size of the array(candidates);
class Solution {
    int targ;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        targ = target;
        
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer>temp, int index, int sum){
        //base
        if(sum == targ){
            result.add(new ArrayList<>(temp));
        }
        if(sum > targ){
            return;
        }
        //logic
        for(int i = index; i<candidates.length; i++)
        {
            //action
            temp.add(candidates[i]);
            
            //recurse
            backtrack(candidates, temp, i, sum + candidates[i]);
            
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}