class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k==0)
            return result;
        backtrack(k,n,0,new ArrayList<>(),1);
        return result;
    }
    
    private void backtrack(int k,int target,int sum,List<Integer> temp,int index)
    {
        // base case
        if(sum==target && temp.size()==k)
        {
            Collections.sort(temp);
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum>target)
            return;
        
        //logic
        for(int i=index;i<10;i++)
        {
            temp.add(i);
            backtrack(k,target,sum+i,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

// Time Complexity: O(n^m)
// Space Complexity: O(n+m)