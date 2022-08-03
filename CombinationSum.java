// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list1=new ArrayList<>();
        backtracking(list1,new ArrayList<>(),candidates,target,0);
        return list1;
    }
    private void backtracking(List<List<Integer>> list1,List<Integer> tempList,int[] candidates, int target, int index){
        if(target==0){
            list1.add(new ArrayList<>(tempList));
        }
        else if(target<0){
            return;
        }
        else{
            for(int i=index;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backtracking(list1,tempList,candidates,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}