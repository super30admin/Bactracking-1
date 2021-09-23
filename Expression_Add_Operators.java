// Time Complexity : O(4^L), You have 4 options to choose(Number,-,+,*) for the next index thus creates 4^L time in recursion.
// Space Complexity : O(L) + O(L) = O(L), 1st O(L) for string and second O(L) for recursive stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,target,0,0,0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail, StringBuilder sb){
        //base
        if(index==num.length()){
            if(calc==target){
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i= index; i<num.length();i++){
            //preceding zero case (Eg-059 is counted as 59)
            if(i!= index && num.charAt(index)=='0') continue;
            long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();
            if(index==0){
                sb.append(curr);
                helper(num,target,i+1, curr, curr, sb);
                sb.setLength(len); //backtracking line
            } else{
                //+
                sb.append('+');
                sb.append(curr);
                helper(num,target,i+1,calc + curr,curr, sb);
                sb.setLength(len); //backtracking line(resetting to previous len)
                //-
                sb.append('-');
                sb.append(curr);
                helper(num,target,i+1,calc - curr,-curr, sb); 
                sb.setLength(len);//backtrack to the previous stringbuilder len
                //*
                sb.append('*');
                sb.append(curr);
                helper(num,target,i+1,calc - tail + tail*curr,tail*curr, sb);
                sb.setLength(len);//backtrack to the previous stringbuilder len
            }
            
        }
        
    }
}