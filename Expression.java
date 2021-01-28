/*
time complexity: exponential 
*/
class Solution {
    List<String> result;
    int target;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        this.target = target;
        
        if(num.length() == 0 || num == null)return result;
        
        
        helper(num,"",0,0,0);
        return result;
    }
    
    private void helper(String num, String path, int index, long calc, long tail){
        if(index == num.length()){
            if(calc == this.target){
                result.add(path);
            }
            return;
        }
        
        
        
        for(int i = index; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i +1));
            
            if(index != i && num.charAt(index) == '0')continue;
            
            if(index == 0){
                helper(num,path+curr,i+1,curr,curr);
            }
            else{
                //"+" case
                helper(num,path + "+" + curr,i+1, calc + curr, curr);
                
                //- case
                helper(num,path + "-" + curr, i+1, calc - curr, -curr);
                
                //* case
                helper(num, path + "*" + curr,i+1, calc - tail + tail * curr, tail*curr);
            }
        }
    }
}