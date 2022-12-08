// Time Complexity : 4 ^ N
// Space Complexity : O(N)
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0) return new ArrayList<>();
        res=new ArrayList<>();
        
        helper(num, target, 0, 0, 0,"");
        
        return res;
    }
    
     private void helper(String num,int target, int index, long calc, long tail,String path){
        //base
        if(index==num.length()){
            if(calc==target){
                    res.add(path);
                }
                return;
        }
        
        //logic
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0') continue;
            long curr=Long.parseLong(num.substring(index, i+1));
            //base
            if(index==0){
                helper(num, target,i+1 ,curr, curr, path + curr);
                
            }
            else{
            //addition case
                helper(num, target,i+1 ,calc+curr, + curr, path + "+" + curr);
                
            //substraction case
                helper(num, target,i+1 ,calc-curr, - curr, path + "-" + curr);
                
            //multiplication case
                helper(num, target,i+1 ,calc-tail+tail*curr, tail * curr, path + "*" + curr);
        }
        }
    }
}