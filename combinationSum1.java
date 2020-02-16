class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0)
            return result;
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] candidates,int target,int sum,List<Integer> temp,int index)
    {
        // base case
        if(sum==target)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum>target)
            return;
        
        //logic
        for(int i=index;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            backtrack(candidates,target,sum+candidates[i],temp,i);
            temp.remove(temp.size()-1);
        }
    }
}

// Time Complexity: O(m^n), m=no of candidates, n=target
// Space Complexity: O(m+n)