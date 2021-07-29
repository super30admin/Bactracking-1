//Backtracking Approach 1
//Time Complexity: Worst : O(N raise to power Target); N is number of candidate
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates== null || candidates.length ==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        helper(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    public void helper(int[] candidates, int start, int target, List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList(list));
        }

        if(target < 0){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(candidates,i,target-candidate[i],list,result);
            list.remove(list.size()-1);
        }
    }
}