//o(n) space and exponential time complexity(2^n)
//passed all leetcode cases
//used approach discussed in class

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;
        helper(candidates,target,0, 0, new ArrayList<>() );
        return result;

    }
    private void helper(int[] candidates,int target,int sum,int index, List<Integer> temp){
        if(sum==target){
            result.add(new ArrayList<>(temp));
        }
        if(sum>target) return;
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            helper(candidates,target,sum+candidates[i], i,temp);
            temp.remove(temp.size()-1);
        }
    }
}