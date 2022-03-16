//Time:Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates
// O(N^(T/M))
//Space: O(T/M) --> num of recursive calls


class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        comboSum(candidates, 0, target, new ArrayList<>());
        
        return result;     
    }
    
    private void comboSum(int[] candidates, int index, int target, List<Integer> path) {
        //base
        //when target is 0, we have the solution items in path list
        //add path to result
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //break condition
        //if target is negative, then solution does not exist
        //if we have looked at all items in candidates, then break
        if(target<0 || index == candidates.length)
            return;

        //iterate to add items to path
        for(int i=index; i<candidates.length; i++) {
            //choosing candidates[i] to path
            path.add(candidates[i]);
            //new target will be target-chosen candidate
            comboSum(candidates,i, target - candidates[i], path);
            //undo by removing candidate from path
            path.remove(path.size() - 1);
        }
    }
}