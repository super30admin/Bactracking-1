// 282 Expression Add Operators
// solved on leetcode
// Time complexity : exponential
// Space complexity :  O(n)


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList();
        
        helper(num,target,0,0,0,"");
        return result;
    }
    
    private void helper(String num, int target, long prevNum, long tail, int index,String path){
        
        if(index==num.length()){
            if(prevNum==target){
                result.add(path);
                return;
               
            }
             return;
        }
        
        
        for(int i=index;i<num.length();i++){
            
            if(num.charAt(index)=='0' && index !=i){
                continue;
            }
            long current = Long.parseLong(num.substring(index,i+1));
            
            if(index==0){
                helper(num,target,prevNum+current,current,i+1,path + current);
            }else{
                
                helper(num,target,prevNum+current,current,i+1,path + "+" + current);
                
                helper(num,target,prevNum-current,(-1)*current,i+1,path + "-" + current);
                
                Long multiply = prevNum-tail+ (current*tail);
                    
                helper(num,target,multiply,tail*current,i+1,path+ "*"+ current);
            }
        }
    }
}