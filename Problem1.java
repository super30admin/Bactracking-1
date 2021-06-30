
// Time  - O(N^T) which is exponential
// Space - O(N^T) which is exponential

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();

        // backtracking with index position and maintain a new path
        backtrack(candidates,target,0, new ArrayList<>());
        return result;

    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> path){


        //base

        if(target < 0) return;

        // if the target is 0 then add the path to the list
        if(target == 0) {

            result.add(new ArrayList<>(path));
            return;

        }


        //logic

        // add the path and subtract with target to recurse with the tree
        for(int i = index; i < candidates.length; i++) {

            // action
            path.add(candidates[i]);

            // recurse
            backtrack(candidates,target - candidates[i],i, path);

            // backtrack
            path.remove(path.size() - 1);


        }

    }


}