class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }


    private void helper(int[] candidates, int pivot, List<Integer> path, int target){
        if(target == 0){
         result.add(new ArrayList<>(path));
         return;
        }
         if(target < 0 || pivot == candidates.length) return;
        
        for(int i= pivot; i<candidates.length; i++){
           
            path.add(candidates[i]);

           

            helper(candidates, i, path, target-candidates[i]); //here we are not incrementing 'i' bcz we can repeat the same number  

            path.remove(path.size()-1);
        }

       
    }
}
/*

TC : O(2^n)
SC : O(n)





 */



class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }


    private void helper(int[] candidates, int i, List<Integer> path, int target){
        //base

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || i == candidates.length) return; 




        //logic
        helper(candidates, i+1, path, target);
        
        //dont choose
        //action
        path.add(candidates[i]);

        //recurse
        helper(candidates, i, path, target - candidates[i]);

        //backtrack
        path.remove(path.size()-1);
    }
}


/*

TC : O(2^n)
SC : O(n)





 */