// Time Complexity : O(n*3^n) (for loop+exploring 3 operations at each node)
// Space Complexity : O(3^n) for recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        backTrack(num,target,0,0,0,"",res);
        return res;
    }
    
    private void backTrack(String num, int target, int index, long prevSum, long prevAdd, String path, List<String> res){
        
        //base case
        if(index>=num.length()){
            if(prevSum==target){
                res.add(path);
            }
            return;
        }
        
            //recursive case
        for(int i=index;i<num.length();i++){
            
            long curr= Long.parseLong(num.substring(index,i+1));
            //to handle leading zeroes
            if(num.charAt(index)=='0' &&i!=index){
                continue;
            }
        if(index==0){
            backTrack(num,target,i+1,curr,curr,path+curr,res);
        }
        else{
            //+
            backTrack(num,target,i+1,prevSum+curr, curr,path+"+"+curr,res);
            
            //-
            backTrack(num,target,i+1,prevSum-curr, -curr,path+"-"+curr,res);
            
            
            //*
            backTrack(num,target,i+1,prevSum-prevAdd+prevAdd*curr, prevAdd*curr,path+"*"+ curr,res);
            
        }
        }
        
    
        
        
    }
}