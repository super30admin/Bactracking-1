//time - O(2^n)
//space - O(n)

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates,0, target, new ArrayList<>(), result);
        return result;    
        }
    void helper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> result){
        
         //base
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target <0) return;
        
            
        for(int i=idx; i<candidates.length; i++){
       
            //recursion
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path, result);
            path.remove(path.size()-1);
        }
    }
    }
