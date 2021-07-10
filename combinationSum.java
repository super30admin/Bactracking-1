class CombinationSum{
    // time - O(2^n)
    // space - O(n)
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, new ArrayList<>(), 0, 0, target);
        return result;
    }

    private void helper(int[] candidates, List<Integer> temp, int index, int sum, int target){
        //base
        if(sum > target) return;
        if(sum == target){
            result.add(new ArrayList<>(temp));
        }

        //logic
        for(int i=index; i< candidates.length; i++){
            temp.add(candidates[i]);
            helper(candidates, temp, i, sum + candidates[i], target);
            temp.remove(temp.size()-1);
        }
    }
}