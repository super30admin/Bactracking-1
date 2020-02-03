/*
 * Time Complexity : O(4^n)
 * Space Complexity : 	O(n)
 */
class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        
        if(num.length() == 0){
            return result;
        }
        
        backtrack("", num, target, 0, 0, 0);
        return result;
    }
    
    private void backtrack(String path, String num, int target, long calculated, long tail, int index){
        
        //Base case
        if(index == num.length()){
            if(calculated == target){
                result.add(path);
                return;
            }    
        }
        
        
        
        //Logic
        for(int i=index; i<num.length(); i++){
            
            if(i != index && num.charAt(index) == '0'){
                break;
            }
            
            long current = Long.parseLong(num.substring(index, i+1));
            
            if(index == 0){
                backtrack(path+current, num, target, current, current,i+1);
            }else{
                backtrack(path + "+" + current, num, target, current + calculated, current, i+1);
                backtrack(path + "-" + current, num, target, calculated - current, -current, i+1);
                backtrack(path + "*" + current, num, target, calculated-tail+tail*current, tail*current, i+1);
            }
        }
        
    }
}