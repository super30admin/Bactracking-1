// Time Complexity : O(3*n). n is the length of the String
// Space Complexity : O(3*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList();

        backTrack(num, target, "",0, 0, 0);

        return result;
        
    }
    
    

    private void backTrack(String num,int target,String path,long calculatedVal,long tail,
                           int index){
        
        if(index==num.length()){
            if(calculatedVal == target){
                result.add(path);
            }
            return;
        }
        
        
        for(int i=index;i<num.length();i++){
            
            if(index!=i && num.charAt(index)=='0') break;
            long curr = Long.parseLong(num.substring(index,i+1));
            
            if(index==0)
                backTrack(num,target,path+curr,curr,curr,i+1);
            else{
                backTrack(num,target,path+"+"+curr,calculatedVal+curr,curr,i+1);
                 backTrack(num,target,path+"-"+curr,calculatedVal-curr,-curr,i+1);
                 backTrack(num,target,path+"*"+curr,calculatedVal-tail+tail*curr,tail*curr,i+1);
            }
        }
    }
}
