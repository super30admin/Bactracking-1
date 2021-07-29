//Recursive Approach 1
//Time Complexity: Exponential Time Complexity
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates== null || candidates.length ==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        helper(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    public void helper(int[] candidates, int start, int target, List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList(list));
            return;
        }
        if(target < 0 || start>= candidates.length){
            return;
        }
        //not present
        helper(candidates,start+1,target,new ArrayList(list),result);
        //present
        list.add(candidates[start]);
        helper(candidates,start,target-candidates[start],new ArrayList(list),result);
    }
}