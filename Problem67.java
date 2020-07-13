Executed in Leet code -Yes
Time complexity- o(n2)
Space Complexity- 0(n2)

class Solution {
    List<List<Integer>> result; 
    int target =0;
    public List<List<Integer>> combinationSum(int[] candidates, int targ) {
        target=targ;
        result = new ArrayList<>();
        if(target==0  || candidates==null || candidates.length==0) return result;
        helper(candidates,new ArrayList<Integer>(), 0,0);
        return result;
    }
    private void helper(int[] candidates,List<Integer> tmpResult,int sum, int index){
        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList<Integer>(tmpResult));
            return;
        }
        for(int i=index;i< candidates.length;i++){
            //List<Integer> tmp= new ArrayList<Integer>(tmpResult) ; 
            tmpResult.add(candidates[i]);
            helper(candidates,tmpResult,sum+candidates[i],i);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
