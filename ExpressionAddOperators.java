// Time Complexity : exponential
// Space Complexity : exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<String> result= new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length()==0)        {
            return result;
        }
        helper(num,target,0,"",0,0);
        return result;
    }
    private void helper(String num, int target, int index, String path, long calc, long tail){
        if(index==num.length()){
            if(calc== target){
                result.add(path);
            }
            return;
        }
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0')continue;
            long curr=Long.parseLong(num.substring(index,i+1));
            if(index==0){
                helper(num,target,i+1,path+curr,curr,curr);
            }
            else{
                helper(num,target,i+1,path + "+" + curr,calc+curr,curr);
                helper(num,target,i+1,path + "-" + curr,calc-curr,-curr);
                helper(num,target,i+1,path + "*" + curr,calc-tail+tail*curr,tail*curr);
            }
        }
    }
} 