/*Running Time Complexity: O(4^n)
Space Complexity: Mutable datastructure will take less space 
Successfully Run and Compiled on leetcode
*/
class Solution {
    List<String> result ;
    public List<String> addOperators(String num, int target) {
        //keep track of precedence of operator
        //backtracking 
        result = new ArrayList<>();
        if(num==null || num.length()==0) return result;
        helper(num,target,new StringBuilder(),0,0,0);
        return result;
        
    }
    private void helper(String num, int target,StringBuilder sb, long calc, long tail, int index){
        
        //Base case
        if(index==num.length()){
            if(target==calc){
                result.add(sb.toString());
                return ;
            }
        }
        //logic 
        for(int i = index ;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0') break;
            long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();
            if(index==0){
                sb.append(curr);
                helper(num,target,sb,curr,curr,i+1);//Recurse
                sb.setLength(len);//BackTrack
            }else{
                //+
                sb.append('+');
                sb.append(curr);
                helper(num,target,sb, calc + curr,curr,i+1);//Recurse
                sb.setLength(len);//BackTrack
                //-
                sb.append('-');
                sb.append(curr);
                helper(num,target,sb, calc - curr, -curr, i+1);//Recurse
                sb.setLength(len);//BackTrack
                //*
                sb.append('*');
                sb.append(curr);
                helper(num,target,sb,calc-tail+tail*curr, curr*tail,i+1);//Recurse
                sb.setLength(len);//BackTrack
            }
        }
    }
}