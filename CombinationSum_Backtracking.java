class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
private  void helper(int [] candidates, int index,List<Integer> path, int target ){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 ||index == candidates.length) return;
        for(int i = index;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,i,path,target - candidates[i]);
            //Backtrack
            path.remove(path.size()-1);
        }
    }
}
