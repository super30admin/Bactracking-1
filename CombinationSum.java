//Time Complexity: O(n^n)
//Space complexity:O(maximum length of answer)
//Approach: we used backtracking in this problem

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,0,target,new ArrayList<>());
        return output;
    }
    
    private List<List<Integer>> output = new ArrayList<>();
    
    private void backtracking(int[] candidates,int index, int target,List<Integer> path){
        if(target<0){
            return;
        }
        
        if(target==0){
            output.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            backtracking(candidates,i,target-candidates[i],path);
            path.remove(path.size()-1);
        }
    }
    
}