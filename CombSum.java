/*
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/
class Solution {
    private void doComb(List<List<Integer>> ret, List<Integer> temp, int[] candidates, int trgt, int lv){

        if(trgt == 0){
            ret.add(new ArrayList<>(temp));
        }else if(trgt < 0)
            return;

        for(int i = lv ; i < candidates.length; i++){
            temp.add(candidates[i]);
            doComb(ret, temp, candidates, trgt-candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        doComb(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }
}
