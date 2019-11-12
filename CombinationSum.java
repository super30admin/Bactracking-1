class Solution {
    private void genCombination(int[] candidates, int target, int idx, List<Integer> subres, List<List<Integer>> result) {


        if (target == 0) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.addAll(subres);
            result.add(al);
            return;
        }

        
        if (idx >= candidates.length || target < 0) return;

        for (int i = idx; i < candidates.length; i++) {
            subres.add(candidates[i]);
            genCombination(candidates, target - candidates[i], i, subres, res);
            subres.remove(subres.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> subres = new ArrayList<Integer>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        genCombination(candidates, target, 0, subres, result);
        return result;
    }
}

//Accpeted on leetcode, recursion till base case
//O(N) space complexity 
//O(N) time complexity
