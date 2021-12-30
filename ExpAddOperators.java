// Time complexity :O(4^n)
// Space complexity :O(n)
// leetcode : success

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        
       helper(result, target, num, 0, 0, 0, "");
        
        return result;
    }
    
    private void helper(List<String> result , int target , String num , int index , long prevNum , long tail, String path){
        
        if(index == num.length()){
            
            if( prevNum == target ){
                result.add(path);
                return;
            }
        }
        
        for(int i = index ; i < num.length() ; i++){
            
            if(num.charAt(index) == '0' && index != i){
                continue;
            }
            
            long currNum = Long.parseLong(num.substring(index,i+1));
            
            if(index == 0){
                
                 helper(result, target, num, i + 1, prevNum + currNum, currNum, path + currNum);
            }else{
                
                helper(result, target, num, i + 1, prevNum + currNum, currNum, path + "+" + currNum);
            
                helper(result, target, num, i + 1, prevNum - currNum, -1 * currNum, path + "-" + currNum);    
            
                long newmul = (prevNum - tail) + (tail * currNum);
            
                helper(result, target, num, i + 1, newmul, tail * currNum, path + "*" + currNum);
            }
            
        }
       
        
    }
}
