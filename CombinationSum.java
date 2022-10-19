//Time: O(n^(t/m))
//Space: O(t/m)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path){
//         for loop based recursion
        // if(target < 0)
//             return;
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
        
//         for(int i = index; i < candidates.length; i++){
//             path.add(candidates[i]);
//             helper(candidates, target - candidates[i], i, path);
//             path.remove(path.size() - 1);
//         }
        
        if(target < 0 || index == candidates.length)
            return;
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //do not choose
        helper(candidates, target, index + 1, path);
        //choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        //backtrack
        path.remove(path.size() - 1);
        
    }
}
