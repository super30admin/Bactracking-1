//Time complexity is O(4^N) N is length of given string
//Space complexity is O(N)
class Solution {
    List<String> result =new ArrayList();
    public List<String> addOperators(String num, int target) {
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    public void helper(String num, int target, int index, long currSum, long prev, String expr)   
    {
        if(index==num.length()){
            if(currSum==target){
                result.add(expr);
            }
            return;
        }
        
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0'){
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i+1));
            if(i==0){
                helper(num, target, i+1, curr, curr, ""+curr);
            }
            else{
                //addition addOperator
                helper(num, target, i+1, (curr+currSum), curr, expr+"+"+curr);
                //Subtract
                helper(num, target, i+1, (currSum-curr), -curr, expr+"-"+curr);
                //multiply
                helper(num, target, i+1, (currSum-prev+(curr*prev)), prev*curr, expr+"*"+curr); 
            }
        }
    }
}