class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result= new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    private void helper(int [] candidates, int index, List<Integer> path, int target){
        //base
        if(target==0){
            result.add(new ArrayList<>(path)); 
            return;
        }
        if(target<0 || index==candidates.length) return;
         //not choose
         helper(candidates, index+1, path, target);
         //choose
         path.add(candidates[index]);
         helper(candidates, index,  path, target- candidates[index]);
         path.remove(path.size()-1);
         
    }
}

//class solution 

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result= new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    private void helper(int [] candidates, int index, List<Integer> path, int target){
        //base
        if(target==0){
            result.add(new ArrayList<>(path)); 
            return;
        }
        if(target<0 || index==candidates.length) return;
     
         for (int i = index; i < candidates.length; ++i) {
            // add the number into the combination
            path.add(candidates[i]);
            this.helper(candidates,i, path,target - candidates[i]);
            // backtrack, remove the number from the combination
            path.remove(path.size()-1);
        }
    }
}

//Time Complexity: O(maxK* n)
/Space Complexity: O(m+n)