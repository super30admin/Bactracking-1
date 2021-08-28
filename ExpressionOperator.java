/* Time Complexity :  O(n*4^n)
   Space Complexity :   O(n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num,target,0,0,0,"");
        return res;
    }
    private void helper(String num,int target,int index,long calc,long tail, String path){
        //base
        if(index==num.length()){
            if(calc==target)
            {
            res.add(path);
            }
            return;
        }
        //logic
        for(int i=index;i<num.length();i++){      
            if(num.charAt(index)=='0' && index!=i){
                continue;
            }
            long cur = Long.parseLong(num.substring(index,i+1));
            if(index==0){
                helper(num,target,i+1,cur,cur,path+cur);
            }
            else
            {
                //+
                helper(num,target,i+1,calc+cur,cur,path+ "+" +cur);
                //-
                helper(num,target,i+1,calc-cur,-cur,path+ "-" +cur);
                //*
                helper(num,target,i+1,calc-tail+(tail*cur),tail*cur,path+ "*" +cur);
            }
        }
    }
}