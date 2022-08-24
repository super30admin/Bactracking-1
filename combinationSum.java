//TC : 2^mn
//SC : 2^mn

class Solution {
    List<List<Integer>>  result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates, 0 ,target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates,int pivot,int amount,List<Integer> path){
        if(amount < 0) return;
        //base
        if(amount == 0) {
          //create a new Array List 
        result.add(new ArrayList<>(path));
        return;
        }
      
      //iterate from pivot for all the children
      for(int i = pivot;i<candidates.length;i++){
          
          //action
          path.add(candidates[i]);
          
          //recurse
          helper(candidates, i ,amount - candidates[i], new ArrayList<>(path));
         
          //backtrack
          path.remove(path.size()-1);
      }
    }
}
