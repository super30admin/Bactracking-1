// Time Complexity : o(2^n) exponential 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        if(num==null || num.length()==0) return result;
        
        helper(num,0,target,"",0,0);
        return result;
    }
    private void helper(String num,int index,int target,String path,long calc,long tail){
        //base case
        if(index==num.length()){
            if(calc==target){
                result.add(path);
                return;
            }
        }
        
        //logic
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0') continue;
            long curr= Long.parseLong(num.substring(index,i+1));   //i+1 bcoz exclusive
            if(index==0){
                
                helper(num,i+1,target,path+curr,curr,curr);
                
            }else{
                //+
                helper(num,i+1,target,path+'+'+curr,calc+curr,curr);
                
                //-
                helper(num,i+1,target,path+'-'+curr,calc-curr,-curr);
                
                //*
                helper(num,i+1,target,path+'*'+curr,calc-tail+curr*tail,curr*tail);
            }
        }
    }
}