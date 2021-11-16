// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();
        helper(num, target, 0, "", result,0,0);
        return result;
    }
    
    public void helper(String num, int target, int index, String path, List<String> result, long prevAns, long tail){
        
        if(index==num.length()){
            
            if(prevAns==target){
            result.add(path);
            }
            return;
        }
        
        for(int i=index;i<num.length();i++){
            if(num.charAt(index)=='0' && index!=i){
                continue;
            }
            long currNum=Long.parseLong(num.substring(index,i+1));
            
            if(index==0){
                helper(num, target, i+1, path+currNum, result,currNum,currNum);
                
            }else{
            helper(num,target ,i+1,path+"+"+currNum,result,prevAns+currNum, currNum );
            
            helper(num,target ,i+1,path+"-"+currNum,result,prevAns-currNum, (-1)*currNum);
            
            long newMultiply=(prevAns-tail)+(tail*currNum);
            helper(num, target ,i+1, path+"*"+currNum, result, newMultiply, tail*currNum );
            }
        }
    }
}