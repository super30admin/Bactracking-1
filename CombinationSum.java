// Time Complexity :O(n^n)
// Space Complexity : O(m) max elements added to path where target is > and < 0;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// create a list for path to add to output. write your backtracking method with candidate, target,output,index and path as your passing parameters.
// as the repititions of a single element is allowed, start a for loop from index and iterate over till the end if all aailable elements in candidates.
// if the target sum < 0 and if index exceeds the candidates length, return or else add that path to our output (valid sum==target).

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, target, output, 0, path);
        return output;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> output, int index, List<Integer> path){
        if(target<0){
            return;
        }else if(target==0){
            output.add(new ArrayList<>(path));
        }else if(index>=candidates.length){
            return;
        }

        for(int i=index; i<candidates.length;i++){
            path.add(candidates[i]);
            backtracking(candidates, target-candidates[i], output,i,path);
            path.remove(path.size()-1);
        }
    }
}