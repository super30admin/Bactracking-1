class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null || candidates.length==0)
            return result;
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] candidates,int target,int sum,List<Integer> temp,int index)
    {
        // base case
        if(sum==target)
        {
            //System.out.println(sum+" "+target);
            Collections.sort(temp);
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum>target)
            return;
        
        //logic
        for(int i=index;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            backtrack(candidates,target,sum+candidates[i],temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

// Time Complexity: O(n^m)
// Space Complexity: O(n+m)