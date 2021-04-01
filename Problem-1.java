// Time Complexity  : O(N^(T/M)) where n is the array length , T/M - height of the tree, T - target value , M - Minimum number of the array.
// Space Complexity : O(T/M) Using Recursion Stack

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtracking(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    
    public void backtracking(int[] candidates, int target, int sum, List<Integer> temp, int index) {
        //base case
        if(sum == target) 
            result.add(new ArrayList<>(temp));
        if(sum> target) return;
        //logic
        for(int i = index; i< candidates.length; i++){
            temp.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}