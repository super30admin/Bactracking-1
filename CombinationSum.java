// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    List<List<Integer>> output;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        output = new LinkedList<>();

        if(candidates == null){
            return output;
        }

        backTrack(candidates,target,0,new LinkedList<>());
        return output;

    }

    public void backTrack(int[] candidates, int target,int index,List<Integer> list){

        if(target < 0){
            return;
        }
        else if(target == 0){
            output.add(new ArrayList<>(list));
        }

        for(int i=index;i<candidates.length;i++){

            list.add(candidates[i]);
            backTrack(candidates,target-candidates[i],i,list);
            list.remove(list.size()-1);

        }
    }
}