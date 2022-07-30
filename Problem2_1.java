//Time Complexity: O(2^n)
//Space Complexity: O(2^n); since a new string is created at every call
//Code run successfully on LeetCode.

public class Problem2_1 {

    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        if(num == null || num.length() == 0)
            return new ArrayList<>();
        
        
        result = new ArrayList<>();
        
        helper(num, 0 , target, "", 0, 0);
        return result;
        
    }
    
    private void helper(String num, int index, int target, String path, long calc, long tail){
        
        if(index == num.length()){
            
            if(calc == target){
                result.add(path);  
            }
             return;
        }
        
        for(int i = index; i < num.length(); i++){
            
            if(index != i && num.charAt(index) == '0')
                continue;
            long curr =Long.parseLong(num.substring(index, i +1));
            
            if(index == 0)
                helper(num, i +1, target, path+curr, curr, curr);
            
            else{
                 //*case
                helper(num, i+1, target,  path+'*'+curr, calc - tail + tail * curr, tail*curr);
                
                //+ case
                helper(num, i+1, target, path+'+'+curr, calc + curr, curr);
                
                //-case
                helper(num, i+1, target,  path+'-'+curr, calc - curr, -curr);
                
               
            }
        }
    }
}
