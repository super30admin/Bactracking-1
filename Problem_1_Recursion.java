// Time complexity - O(2^n)
// Space complexity - O(n^n) {Tmp list at each node}

// recursive solution - tmp list at each node

class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tar = target;
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        helper(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void helper(int[] candidates, List<Integer> tmp, int sum, int index ){
        // base
        if(sum > tar || index >= candidates.length){
            return;
        }
        if(sum == tar){
            result.add(tmp);
            return;
        }
        // logic
        // choose
        helper(candidates,new ArrayList<>(tmp), sum, index+1);
        // dont choose
        tmp.add(candidates[index]);
        helper(candidates,new ArrayList<>(tmp), sum + candidates[index] , index);
    }
}
