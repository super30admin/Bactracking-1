//Time Complexity:Exponential
//Space Comeplexity:O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    private void helper(int []candidates,int index,List<Integer> path,int target){
        //base case
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(index==candidates.length || target<0)
            return;
        //logic
        //not choose
        helper(candidates,index+1,path,target);
        path.add(candidates[index]);
        //choose
        helper(candidates, index,path,target-candidates[index]);
        path.remove(path.size()-1);
    }
}
