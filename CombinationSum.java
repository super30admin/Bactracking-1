class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }
    
    public void helper(int[] candidates, int i, int target, List<Integer> path){
        if(i==candidates.length || target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        helper(candidates, i+1, target, path);
        path.add(candidates[i]);
        helper(candidates, i, target-candidates[i], path);
        path.remove(path.size()-1);
    }
}

//Time complexity - Exponential time complexity
//Space complexity - exponential
