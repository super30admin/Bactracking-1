// Time Complexity : O(3^n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass Solution {
    public List<String> addOperators(String num, int target) {
        List<String> output = new ArrayList();
        backtracking(output,num,target,0,"",0,0);
        
        return output;
    }
    
    public void backtracking(List<String> output, String num, int target, int index, String exp, long prevSum, long prevOperation){
        if(index>=num.length()){
            if(prevSum==target){
                output.add(exp);
            }
            return;
        }
        for(int i=index;i<num.length();i++){
            
            Long curr = Long.parseLong(num.substring(index,i+1));
            
            if(num.charAt(index)=='0' && i!=index){
                continue;
            }
            
            if(index==0){
                backtracking(output, num, target, i+1, exp + curr, curr, curr);    
            }else{
                backtracking(output, num, target, i+1, exp + "+" + curr, prevSum+curr, curr);
                backtracking(output, num, target, i+1, exp + "-" + curr, prevSum-curr, curr*(-1));
                backtracking(output, num, target, i+1, exp + "*" + curr, prevSum-prevOperation+(prevOperation*curr), prevOperation*curr); 
                 }      
        }
    }        
}