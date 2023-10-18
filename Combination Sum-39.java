class Solution {
    //Time Complexity: O(2n)
//Space Complexity:O(2n)
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {      
        if(candidates == null || candidates.length == 0 ){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;}

    private void recurse(int[] candidates,int target, int index, List<Integer> path){
        if(index== candidates.length || target < 0 ){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        recurse(candidates, target, index + 1, new ArrayList<>(path));
        path.add(candidates[index]);
        //Case choose or 1 case
        recurse(candidates, target- candidates[index], index, new ArrayList<>(path));
    }

}
