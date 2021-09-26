//Time complexity: O(2^N)
//Space complexity: O(N)
class Solution {
    List<List<Integer>> result;
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        n = candidates.length;
        helperMethod(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helperMethod(int[] candidates, int index, List<Integer> path, int target) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == n || target < 0) {
           return;
        }
        //not choose
        helperMethod(candidates, index + 1, path, target);
        
        //choose
        path.add(candidates[index]);
        helperMethod(candidates, index, path, target - candidates[index]);
        
        //backtrack
        path.remove(path.size()-1);
    }
}