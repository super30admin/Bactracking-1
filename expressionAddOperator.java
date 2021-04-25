// Time Complexity : O(N*4^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,target,"",0,0,0);
        return result;
    }
    private void helper(String num,int target, String path,long calcVal,long tail, int index){
        System.out.println("Path : "+path+" Calc Val : "+calcVal+" Tail : "+tail+" Index : "+index);
        if(index == num.length()){
            if(target == calcVal) {
                result.add(path);
            }
            return;
        } 
        for(int i = index ; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            System.out.println(curr);
            if(index!=i && num.charAt(index)=='0') continue;
            if(index==0){
                //Case 1
                helper(num,target,path+curr,curr,curr,i+1);
            }else{
                //+
                helper(num,target,path+'+'+curr,calcVal+curr,curr,i+1);
                //-
                helper(num,target,path+'-'+curr,calcVal-curr,-curr,i+1);
                
                //*
                helper(num,target,path+'*'+curr,(calcVal-tail)+(tail*curr),tail*curr,i+1);
            }
        }
    }
}
