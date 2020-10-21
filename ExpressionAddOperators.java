//TC : exponential, branched by operator choices(+,-,*), nothing, O(4^len(numString)-1)
//SC : max recursion stack, O(len(numString)-1)

class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();
        String expr = new String();
        helper(num, target, expr, 0, 0, 0);
        return result;
    }
    
    private void helper(String input, int target, String expr, long prev, long cur, int index){
        //base
        if(index==input.length()){
            if(cur==target){
                result.add(expr);
            }
            return;
        }
        
        //make a choice
        for(int i=index; i<input.length(); i++){
            
            //preceeding zeros
            if(index!=i && input.charAt(index)=='0') return;
            
            long elem = Long.parseLong(input.substring(index, i+1));
            if(index==0){
                helper(input, target, expr+elem, elem, elem, i+1);
            }
            else{
                //+
                helper(input, target, expr+"+"+elem, elem, cur+elem, i+1);
                //-
                helper(input, target, expr+"-"+elem, -elem, cur-elem, i+1);
                //*
                helper(input, target, expr+"*"+elem, prev*elem, cur-prev+prev*elem, i+1);
            }
        }
    }
}