// Time Complexity : exponential
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : thought of recurssion, backtracking didn't strike directly

//backtracking approach
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //for optimization that once target is reached, we can return
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start){
        //if target exceeded then return
        if(remain < 0)
            return;
        //we need to create new deep copy of tempList bcoz otherwise it will be overwritten in subsequent steps
        if(remain == 0)
            list.add(new ArrayList<>(tempList));
        else{
            //iterating through elements, keeping i as pivot element
            //we are taking all the scenarios, we have pivot which we always choose and then try all combinations
            //this is same as choose not choose
            for(int i=start;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

//recurssion approach
class Combination sum {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, new ArrayList<>(), target, 0);
        return list;
    }

    public void helper(int[] candidates, List<Integer> tmp, int target, int index){
        if(target < 0 || index >= candidates.length)
            return;
        if(target == 0){
            //we need to create new deep copy of tempList bcoz otherwise it will be overwritten in subsequent steps
            list.add(new ArrayList<>(tmp));
            return;
        }
        //not choose
        helper(candidates, tmp, target, index+1);
        //choose
        tmp.add(candidates[index]);
        //in this we are passing index as same element can be chosen multiple times
        helper(candidates, tmp, target-candidates[index], index);
        tmp.remove(tmp.size()-1);
    }
}