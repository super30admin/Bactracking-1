//Time Complexity:O(4^N)
//Space Complexity:O(N)
//In this problem, I'll be creating a stringbuilder which will build each combinations, as I call the recursive function and a prev value which will keep track of the value at the calling function and a next to keep track of the value in the called function. These two operators will help me to keep track of the target value in the fly. At every recursion call, I'll be trying all possible combinations of operators and string values and when I cross the length of the string, I'll be checking if the prev is equal to the target, If so, I'll append it to the result list. The precedence of the multiplication operator has been handled in the fly by  subtracting the prev value from the next value and adding the multiplied next value with the cur value to get the correct answer.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        if(num.length()==0){
            return res;
        }
        backtrack(res,num,sb,0,target,0,0);
        return res;
    }
    private void backtrack(List<String> res, String num, StringBuilder sb, int pos,int target, long prev, long next){
        if(pos==num.length()){
            if(target==prev){
                res.add(sb.toString());
            }
            return;
        }
        for(int i=pos;i<num.length();i++){
            if(num.charAt(pos)=='0'&&i!=pos){
                break;
            }
            long cur=Long.parseLong(num.substring(pos,i+1));
            int len=sb.length();
            if(pos==0){
                backtrack(res,num,sb.append(cur),i+1,target,cur,cur);
                sb.setLength(len);
            }
            else{
                backtrack(res,num,sb.append('+').append(cur),i+1,target,prev+cur,cur);
                sb.setLength(len);
                backtrack(res,num,sb.append('-').append(cur),i+1,target,prev-cur,-cur);
                sb.setLength(len);
                backtrack(res,num,sb.append('*').append(cur),i+1,target,prev-next+next*cur,next*cur);
                sb.setLength(len);
            }
        }
    }
}