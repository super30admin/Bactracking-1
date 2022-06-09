//https://leetcode.com/problems/expression-add-operators/

// Time Complexity :O(exponential) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        helper(num,target,0,0,0,"");
        return result;
    }
    private void helper(String num,int target,long calc, long tail,int idx,String path)
    {
        //base
        if(idx==num.length())
        {
            if(calc==target)
            {
                result.add(path);
            }
            return;
        }
        //logic 
        for(int i=idx;i<num.length();i++)
        {
            long curr=Long.parseLong(num.substring(idx,i+1)); //1 12 123
            if(num.charAt(idx)=='0' && idx!=i) continue;  //0 is fine 05 is not fine i gives the substring
            //when index==0 there are no operators to add
            if(idx==0)
                helper(num,target,curr,curr,i+1,path+curr);
            
            else{
                //+
                helper(num,target,calc+curr,curr,i+1,path+"+"+curr);
                //-
                 helper(num,target,calc-curr,-curr,i+1,path+"-"+curr);
                //*
                 helper(num,target,calc-tail+tail*curr,tail*curr,i+1,path+"*"+curr);
            }
            
        }
    }
}


