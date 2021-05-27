// Time complexity - O(nxn)
// Space complexity - O(nxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        if(num.length() == 0 || num == null){
            
            return result;
        }
        
        helper(num, target, "", 0, 0, 0);
        
        return result;
        
        
        
    }
    
    private void helper(String num, int target, String path, long calc, long tail, int index){
        
       
       // if(num)
        //base
        if(index == num.length() && target == calc){
            
            result.add(path);
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i ++){
             //precedent 0
            if(num.charAt(index) == '0' && index != i) continue;
           long curr = Long.parseLong(num.substring(index,i+1));
            
            if(index == 0){
                
                helper(num, target, path+curr, curr, curr,i +1);
            }
            
            else {
                //for +
                helper(num, target, path + '+'+ curr,calc + curr, curr,i +1);
                //for -
                helper(num, target, path + '-'+ curr,calc - curr, -curr,i +1);
                //for *
                helper(num, target, path + '*' + curr, calc - tail + tail * curr, tail * curr,i +1);
                
            }
        }
        
    }
}