//Expression add operator
// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this : its going wrong with the 0 case, though i wrote the condition if character is 0 and index is not
//equals to i
//code

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> output= new ArrayList<>();
        backtracking(output,num,0,target,"",0,0);
        return output;
    }
    
    
    
  private void backtracking(List<String> output,String num, int index,int target,String expr,  long prevsum, long prevAddition)
    {
        //base case
        if(index>=num.length())
        {
            if(prevsum==target)
            {
                output.add(expr);
            }
        }
        //recursive case
        for(int i=index;i<num.length();i++){
            
        Long curr=Long.parseLong(num.substring(index,i+1));
       
        if(num.charAt(index)== '0' && i!=index){
            continue;
        }
            
        
        if(index==0)
        {
            backtracking(output,num,index+1,target,expr+curr,curr,curr);
        }
        else
        {
            //+
            backtracking(output,num,index+1,target,expr+'+'+curr,prevsum+curr,curr);
            //-
             backtracking(output,num,index+1,target,expr+'-'+curr,prevsum-curr,curr);
            //*
             backtracking(output,num,index+1,target,expr+'*'+curr,prevsum-prevAddition+prevAddition*curr,prevAddition*curr);
        }
    }
    }
}

//Combination sum
// Time Complexity : 0(n^n)
// Space Complexity :0(m) max elements i can add in my path without exceeding or gib=ving less than zero.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : 
//code


class Solution {
        List<List<Integer>> output= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
       backtracking(candidates,target,0,path);
        return output;
        
}
    private void backtracking(int[] candidates, int target, int index, List<Integer> path)
    {
        if(target<0)
        {
            return;
            
        }
        else if(target==0)
        {
            output.add(new ArrayList<>(path));
        }
        else if(index>=candidates.length)
        {
            return;
        }
        
        for(int i=index;i<candidates.length;i++)
        {
            path.add(candidates[i]);
            backtracking(candidates,target-candidates[i],i,path);
            
            path.remove(path.size()-1);
        }
    }
    
    
}
