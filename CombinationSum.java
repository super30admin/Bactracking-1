//time - O(2^n)
//space - O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int index, int target, List<Integer> path){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i=index; i<candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, i, target-candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}
