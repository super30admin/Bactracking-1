// Time Complexity : O(2^n) n is target
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CombinationSum {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target==0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findCombination(0, target, new ArrayList<>(),candidates,result);
        return result;
    }
    
    private void findCombination(int index, int remaining, List<Integer> tempList,int[] candidates, List<List<Integer>> result){
        if(remaining<0) return;
        else if(remaining==0) result.add(new ArrayList<>(tempList));
        else
        {
            for(int i=index;i<candidates.length;i++)
            {
                tempList.add(candidates[i]);
                findCombination(i,remaining-candidates[i],tempList,candidates,result);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}