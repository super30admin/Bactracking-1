//Time complexity: O(2^N)
//Space complexity: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helperMethod(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    
    public void helperMethod(int[] candidates,int index, List<Integer> path,int target) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
        }
        if(target < 0) {
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helperMethod(candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
        
    }

}