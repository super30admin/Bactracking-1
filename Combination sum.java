// Time Complexity 0(n^n) number candidates in the List
// space Complexity 0(1)
// Code successfully executed in leetcode
class Solution {
            List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //base case
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates,target,0, new ArrayList<>(), 0);
        return result;
        
    }
    private void backtrack(int[] candidates, int target,int sum, List<Integer> temp, int index){
        //base case
        if(sum == target){          //  The target is achieved using the list
            result.add(new ArrayList<>(temp)); // adding  result to list
            return ;
        }
    if(sum > target) return; // means the last element in the list exceeded the sum hence needs to be backtracked
        //logic case
        for(int i=index;i < candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates,target, sum+candidates[i],temp,i);
            //removing element physically from list 
            temp.remove(temp.size()-1);
        }
        
    }
}