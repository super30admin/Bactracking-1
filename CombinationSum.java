/**

TC - O(2^target/min candidate value)
SC - O(target/candidate value)
**/
class Solution {
    
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), 0);
        return results;
    }
    
    private void combinationSumHelper(int candidates[], int target, int start, List<Integer> combination, int combinationSum)
    {
        if (combinationSum > target)
        {
            return;    
        }
        
        // base case
        if (target == combinationSum)
        {
            results.add(new ArrayList<>(combination));
            return;
        }
        
        // explore candidates   
        for (int i=start; i<candidates.length; i++)
        {
           combination.add(candidates[i]);
           combinationSumHelper(candidates, target, i, combination, combinationSum + candidates[i]);
           combination.remove(combination.size() - 1);
        }
    }
}
