//Time - O(2^n)
//Space - O(n*k)
class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0,candidates,target,0, new ArrayList<Integer>());
        return new ArrayList<>(res);
    }

    public void helper(int idx, int[] candidates, int target, int sum, List<Integer> path){
    //base
    if(sum>target){
        return;
    }

    //logic
    //action
    if(sum==target){
        res.add(new ArrayList<Integer>(path));
        return;
    }

    //recurse
    for(int i=idx;i<candidates.length;i++){
        path.add(candidates[i]);
        helper(i,candidates,target,sum+candidates[i],path);
        //backtrack
         path.remove(path.size()-1);
    }
    }
}

