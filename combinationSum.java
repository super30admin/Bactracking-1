//Time Complexity: O(N^h) or O(N^((T/minEl)+1)) where T is the target; minEl is the minimum element in candidates
//Space Complexity: O(h) or O((T/minEl)+1) where h is the height of the tree

//Code
class Solution {
    private List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, new ArrayList<>());
        return output;
        
    }
    private void backtracking(int[] candidates, int target, int index, List<Integer> path){
        //base case
        if(target<0){
            return;
        }
        else if(target==0){
            output.add(new ArrayList<>(path));
        }
        //logic
        for(int i = index; i<candidates.length;i++){
            path.add(candidates[i]);
            
            //recur
            backtracking(candidates, target-candidates[i], i, path);
            
            //backtracking
            //2,3 ->
            path.remove(path.size() - 1);
        }
        
        //backtracking
    }
}