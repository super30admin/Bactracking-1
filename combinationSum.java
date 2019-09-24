//Time Complexity:O(N logN)
//Space Complexity:O(N)
//In this problem, I'll be having a temp list to keep track of the intermediary results. I'll then call my backtrack function, by passing the res list, temo list, target , input and the current index as the input. If the target is less than 0, I'll simply be returning. If it is equal to 0, I'll be appending the temp list at that instant to the result list. Else, I'll iterare over the length of the input array and then add elements to the temp list and call the backtrack function recursively. After reaching the parent function, I'll be popping the last added element from the result list.
//This code was exeuted successfully and got accepted in leetcode. 

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(res,temp,candidates,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int i){
        if(target<0){
            return;
        }
        else if(target==0){
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int j=i;j<candidates.length;j++){
                temp.add(candidates[j]);
                backtrack(res,temp,candidates,target-candidates[j],j);
                temp.remove(temp.size()-1);
            }
        }
    }
}