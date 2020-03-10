i
class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        //edge case
        if(candidates == null || candidates.length ==0) 
            return result;
        combinationSumUtil(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    private void combinationSumUtil(int[] candidates, int target, List<Integer> temp, int index){
        //base case, when to stop recursion
        if(target < 0) return;
        
        //when to add cur answer to result
        if(target == 0) 
            result.add(new ArrayList<>(temp));

        //logic
        for(int i=index; i<candidates.length; i++){
            /*just skip when our target is less than the cur number, no point in exploring that path. As all the
            numbers are positive, we wont get sum which would be equal to target*/
            if(target < candidates[i])  
                continue;
            else{
                //action
                temp.add(candidates[i]);
                //recurse
                combinationSumUtil(candidates, target-candidates[i], temp, i); //duplicates allowed. use same index
                //backtrack
                temp.remove(temp.size()-1);                
            }
        }
    }
}
