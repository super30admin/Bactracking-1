// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         if(candidates == null) return result;
//         helper(candidates, 0, new ArrayList<>(), target);
//         return result;
//     }
//     private void helper(int[] candidates, int i, List<Integer> path, int target){
//         //base
//         if(target == 0){
//             result.add(path);
//             return;
//         }
//         if(i == candidates.length || target < 0){
//             return;
//         }
//         //don't choose
//         helper(candidates, i+1, path, target);
//         //choose
//         List<Integer> li = new ArrayList<>(path);
//         li.add(candidates[i]);
//         helper(candidates, i, li, target-candidates[i]);
//     }
// }
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    private void helper(int[] candidates, int i, List<Integer> path, int target){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i == candidates.length || target < 0){
            return;
        }
        //don't choose
        helper(candidates, i+1, path, target);
        //choose
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, i, path, target-candidates[i]);
        //backtrack
        path.remove(path.size()-1);
    }
}