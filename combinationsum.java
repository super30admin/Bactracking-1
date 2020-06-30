//Time Complexity:O(2^n)
//Space Complexity:O(n)

class Solution {
    List<List<Integer>> result;
    int res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList();
        res=target;
        if(candidates==null || candidates.length==0){
            return result;
        }
        backtrack(candidates,0,new ArrayList(),0);
        return result;
    }
    private void backtrack(int[] candidates,int sum,List<Integer> temp,int index){
        if(sum==res){
            result.add(new ArrayList(temp));
            return;
        }
        if(sum>res){
            return;
        }
        
        
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates,sum+candidates[i],temp,i);
            temp.remove(temp.size()-1);
        }
    }
}