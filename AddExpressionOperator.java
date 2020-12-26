/*
Time Complexity : Exponential
Space Complexity : O(digits in integer)
Idea : We have 4 choices either we add (+,-,*) or no operator. We can never add operator when position is 0 so
we always skip there for other positions we take one of the three operators since the precedence of multiplication
has to be accounted we keep track of last operation that was performed and revert our value by using the formula.
We backtrack for strinbuilder by keeping track of the length before starting the recursion and the again settingthe old length.
*/
class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        if(num == null || num.length() == 0){
            return ans;
        }
        helper(num,new StringBuilder(""),target,0,0,0);
        return ans;
    }
    
    public void helper(String num,StringBuilder path,int target,int pos,long curr,long lastOp){
        if(pos == num.length()){
            if(curr == target){
             ans.add(path.toString());
             return;
            }
        }
        for(int i=pos;i<num.length();i++){
           if(i > pos && num.charAt(pos) == '0') break;
            String valS = num.substring(pos,i+1);
            long val = Long.parseLong(valS);
            int len = path.length();
            if(pos == 0){
                helper(num,path.append(valS),target,i+1,val,val);
                path.setLength(len);
            }else{
                helper(num,path.append("+").append(valS),target,i+1,curr+val,val);
                path.setLength(len);
                helper(num,path.append("-").append(valS),target,i+1,curr-val,-val);
                path.setLength(len);
                helper(num,path.append("*").append(valS),target,i+1,curr-lastOp + lastOp*val,lastOp*val);
                path.setLength(len);
            }
        }
    }
   
}