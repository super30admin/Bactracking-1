/*

time complexity: exponential
space complexity: O(n)
*/
class combinationSum {
    
    List<List<Integer>> result; 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates.length == 0){
                return result;
            }
        result = new ArrayList<>();
        helper(candidates, target, 0,new ArrayList<>());
        return result;
    }
    
    
    private void helper(int[] candidates, int target, int index,  List<Integer> currList){
        //base cases
            if(index == candidates.length || target < 0){
                return;
            }
            if(target == 0){
                result.add(new ArrayList<>(currList));       
                return;
            }
            
            //choose
            currList.add(candidates[index]);
            helper(candidates, target - candidates[index], index,currList);//creating a new copy of the list 
            currList.remove(currList.size()-1);
        
            //dont choose
            helper(candidates, target , index + 1, currList); //creating a new copy of the list 
            
           
            
    }
}
