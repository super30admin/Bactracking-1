class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, target, 0 , new ArrayList<>());
        return result;
        
    }
    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(index == candidates.length || target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //Do not choose or 0
        recurse(candidates, target, index + 1, path);
        path.add(candidates[index]);
        //choose or 1 case
        recurse(candidates, target - candidates[index], index, path);
        path.remove(path.size() -1);
    }

}