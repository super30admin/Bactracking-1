/* Time complexity: O(n*2^n)
space complexity: O(n)
*/

class Solution{
    List<List<Integer>> result; int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        targ = target;
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
        if(sum == targ || index >= candidates.length) return;
        if(sum == targ){
            result.add(new ArrayList<>(temp));
            return;
        }
    }
    for(int i=0; i<candidates.length; i++){
        temp.add(candidates[i]);
        backtrack(candidates, temp, sum+candidates[i], i);
        temp.remove(temp.size() - 1);
    }
}