// 39.
//recursive implementation
//2 choices at each index -> choose or dont choose -> modify index and current sum accordingly -> recurse
//time - O(m2^n) -> n length of candidates, m -> target
//space - O(m + n) for the call stack and O(m2^n) for the extra copy of arrays passed into recursive calls

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> valid = new ArrayList<>();
        
        helper(candidates, target, 0, valid, result, 0);
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int currentSum, List<Integer> valid, List<List<Integer>> result, int index) {
        //base
        if(currentSum == target)
        {
            result.add(valid);
            return;
        }
        if(currentSum > target || index >= candidates.length)
        {
            return;
        }
        //logic
        //dont choose
        helper(candidates, target, currentSum, new ArrayList<>(valid), result, index + 1);
        //choose
        valid.add(candidates[index]);
        helper(candidates, target, candidates[index] + currentSum, new ArrayList<>(valid), result, index);
    }
        
        //backtracking implementation
        //time - O(m2^n) -> n length of candidates, m -> target
        //space - O(m + n) for the call stack 
        
        private void helper(int[] candidates, int target, int currentSum, List<Integer> valid, List<List<Integer>> result, int index) {
        //base
        if(target == currentSum)
        {
            List<Integer> temp = new ArrayList<>(valid);
            result.add(temp);
            return;
        }
        if(currentSum > target)
        {
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++)
        {
            valid.add(candidates[i]);
            helper(candidates, target, currentSum + candidates[i], valid, result, i);
            valid.remove(valid.size() - 1);
        }
    }
    
    // i/p - [2,3] with 6 target
    // call stack
    // [] -> [2] -> [2,2] -> [2,2,2] (copy goes to result) -> (backtrack the last 2) -> [2,2]  -> [2,2,3]  -> backtrack the last 3 
    //-> [2,2] -> backtrack -> [2] -> [2, 3] (copy goes to result) -> backtrack -> [2] -> backtrack -> [] -> index crosses here
}
