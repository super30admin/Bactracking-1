// Time Complexity :O(2^n) n-length of the array
// Space Complexity :O(m+n)  m-target
// Did this code successfully run on Leetcode :yes
// Problems Faced: -
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;
        backtracking(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    private void backtracking(int[] candidates,int target,int sum,List<Integer> list,int index)
    {
       if(sum>target) return;
       if(sum==target)
       {
           result.add(new ArrayList<>(list));
       }
        for(int i=index;i<candidates.length;i++)
        {
         list.add(candidates[i]);
         backtracking(candidates,target,sum+candidates[i],list,i);
         list.remove(list.size()-1);
        }
    }
}

/*
//Recursive Solution
// Time Complexity :O(2^n) n-length of the array
// Space Complexity :O(2^n) because new array List is created at every dont choose and (2^n)/2 is still 2^n  
// Did this code successfully run on Leetcode :yes
// Problems Faced: -
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;
        backtracking(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    private void backtracking(int[] candidates,int target,int sum,List<Integer> list,int index)
    {
       if(sum>target || index==candidates.length) return;
       if(sum==target)
       {
           result.add(list);
           return;
       }
        //dont choose
        backtracking(candidates,target,sum,new ArrayList<>(list),index+1);
        
        //choose
        list.add(candidates[index]);
        backtracking(candidates,target,sum+candidates[index],list,index);   
       
    }
}
*/