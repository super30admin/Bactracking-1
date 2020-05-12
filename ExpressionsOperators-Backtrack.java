class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        helper(num,target,"",0,0,0);
        
        return result;
        
    }
    
    private void helper(String num, int target,String path, long calc, long tail, int index){
        
        if (index == num.length()){
            if (calc == target){
                result.add(path);
                return;
            }
        }
        
        for (int x = index; x < num.length(); x++){
            
            if (index != x && num.charAt(index) == '0')break;
            
            long curr = Long.parseLong(num.substring(index, x+1));
            
            if (index == 0){
                helper(num, target, path+curr,curr,curr, x+1);
            } else {
                helper(num, target, path + "+" + curr,calc + curr,curr, x+1);
                helper(num, target, path + "-" + curr,calc - curr,-curr, x+1);
                helper(num, target, path + "*" + curr,calc - tail + tail * curr,tail * curr, x+1);
            }
            
        }
    }
}