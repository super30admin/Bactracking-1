// Time complexity - O(2^n)
// Space complexity - O()

// Backtrack solution.


class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tar = target;
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer> tmp, int sum, int index ){
        // base
        if(sum > tar) return;
        if(sum == tar){
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        // logic
        for(int i = index; i < candidates.length; i++){
            tmp.add(candidates[i]);
            // recurse
            backtrack(candidates,tmp,sum+candidates[i],i);
            // backtrack
            tmp.remove(tmp.size()-1);
        }
    }
}
