
//Backtracking Solution
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        //Base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(i == candidates.length || target<0) return;

        //not choose case
        helper(candidates, target, i+1, path);

        //choose case
        path.add(candidates[i]);
        helper(candidates, target-candidates[i], i, path);

        path.remove(path.size()-1);
    }
}

//Recurssive For Loop Solution
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path) {
        //Base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target<0) return;

        for(int i = idx; i<candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i, path);

            path.remove(path.size()-1);
        }
    }
}