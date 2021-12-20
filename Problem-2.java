// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        String path = "";
        
        dfs(num,target,0,0,0,path);
        
        return result;
    }
    
    private void dfs(String num, int target, int index,long prevSum, long tail,String path) {
        // base
        if(index == num.length()){
            if(target == prevSum) {
                result.add(path);
            }
            return;
        }
        
        //recurrsion
        for(int i=index;i<num.length();i++) {
            if(num.charAt(index) == '0' && index!=i) {
                continue;
            }
            long currNum = Long.parseLong(num.substring(index,i+1));
            if(index==0) {
                dfs(num,target,i+1, prevSum+currNum, currNum,path+currNum);
            }
            else {
                //+
                dfs(num,target,i+1,prevSum+currNum,currNum,path+ "+"+ currNum);
                
                //-
                dfs(num,target,i+1,prevSum-currNum,-1*currNum,path+ "-"+ currNum);
                
                //*
                long nPrev = prevSum-tail+tail*currNum;
                dfs(num,target,i+1,nPrev,tail*currNum,path+ "*"+ currNum);
            }
        }
    }
}