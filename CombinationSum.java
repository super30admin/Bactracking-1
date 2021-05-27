/*
Desc : We check every possible combination using recursion and add every combination that produces the target,
for every wrong combination we backtrack(by removing the corresponding elements from path list) and proceed the dfs until the target is achived.
Time Complexity : O(2^n)
Space Complexity : O(1)
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates,target,new ArrayList<>(),0);
        return result;
    }
    private void backtrack(int[] candidates,int target,List<Integer> path,int i){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || i==candidates.length){
            return;
        }
        backtrack(candidates,target,path,i+1);
        path.add(candidates[i]);
        backtrack(candidates,target-candidates[i],path,i);
        path.remove(path.size()-1);
    }
}
