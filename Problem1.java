//Problem1 
//Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time complexity - O(2^n) Space complexity O(2 ^ n) 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(resList, new ArrayList<>(), candidates, target, 0);
        
        return resList;
    }
    
    public void combinationSum(List<List<Integer>> list, List<Integer> childList,int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(childList));
        else{
            for(int i = start; i < candidates.length; i++){
                childList.add(candidates[i]);
                combinationSum(list, childList, candidates, remain - candidates[i], i);
                childList.remove(childList.size() - 1);
            }
        }
    }
}