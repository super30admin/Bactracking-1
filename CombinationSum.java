class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();

        if(candidates == null || candidates.length == 0 || target == 0)
            return res;

        helper(candidates, 0, target, new ArrayList<>());

        return res;
    }
    private void helper(int[] candidates, int index, int target, List<Integer> list) {

        //base
        if(target < 0 || index == candidates.length)
            return;

        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        //logic
        //don't choose
        helper(candidates, index+1, target, list);

        //choose
        list.add(candidates[index]);
        helper(candidates, index, target-candidates[index], new ArrayList<>(list));
        list.remove(list.size()-1);
    }
}