// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        if(num == null || num.length() == 0)
            return result;
        targ = target;
        
        helper(num,"",0,0,0);
        return result;
    }
    
    
    private void helper(String num , String path, long cal , long tail ,int index){
        
        
        if(index == num.length()){
            if(cal == targ)
                result.add(path);
            return;
        }
        
        if(index >= num.length())
            return;
          
        for( int i =  index ; i < num.length() ; i++){
            
            if(i!=index && num.charAt(index) == '0') break;
            
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,path+curr,curr,curr,i+1);
            }
            else{
            helper(num, path+"+"+curr, cal+curr , curr , i+1);
            helper(num, path+"-"+curr, cal-curr ,-curr , i+1);
            helper(num, path+"*"+ curr ,cal- tail +tail*curr,tail *curr,  i+1);
         }
        }
        
        
    }
}