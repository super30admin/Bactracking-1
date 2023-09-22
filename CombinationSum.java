//TC = 2^(m*n)
//SC = 2^(m*n)

class CombinationSum{
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<Integer>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){
        //base
        if(i == candidates.length || target < 0 ) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //not choose
        helper(candidates, target, i+1, path);

        path.add(candidates[i]);

        helper(candidates, target-candidates[i], i, path);
        path.remove(path.size()-1);
    }
}