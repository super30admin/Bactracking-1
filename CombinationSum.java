class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combs = new LinkedList<>();
        getCombinations(candidates, target, 0, combs, result);
        return result;
    }

    public void getCombinations(int[] candidates, int remain, int index, LinkedList<Integer> combs, List<List<Integer>> result) {

        if(remain == 0) {
            result.add(new ArrayList<Integer>(combs));
            return;
        }
        if(remain < 0)
            return;
        
        for(int start = index; start < candidates.length; start++) {
            combs.add(candidates[start]);
            getCombinations(candidates, remain - candidates[start], start, combs, result);
            combs.removeLast();
        }
    } 
}
