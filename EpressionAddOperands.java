class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        backtracking(num, target, 0, 0, 0, "");
        return result;
    }
    
    private void backtracking(String num, int target, int index, long prevSum, long prevAdd, String str){
        //base case
        if(index >= num.length()){
            if(prevSum == target){
                result.add(str);
            }
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i+1));
            
            if(num.charAt(index) == '0' && index != i){
                // System.out.println(index + ":" + i + "-" + curr + " :" +str);
                continue;
            }
            
            if(index == 0){
                backtracking(num, target, i+1, curr, curr, str + curr);
            }
            else{
                //+
                backtracking(num, target, i+1, prevSum + curr, curr, str + '+' + curr);
                //-
                backtracking(num, target, i+1, prevSum - curr, -curr, str + '-' + curr);
                //*
                backtracking(num, target, i+1, prevSum - prevAdd + prevAdd * curr, prevAdd * curr, str + '*' + curr);
                
            }            
        }
        
    }
}

