//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return res;
        helper(candidates, target, 0, new ArrayList<>()); 
        return res;
    }
    private void helper(int[] candidates, int target, int index, ArrayList<Integer>path){
        if(candidates.length==index || target<0) return;
        if(target==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //don't choose
        helper(candidates, target, index+1, path);
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, path);
        path.remove(path.size()-1);
    }
}