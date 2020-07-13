// Time Complexity : O(3^n) m*n is matrix dimensions
// Space Complexity :Height of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ExpressionAddOp {
     List<String> result;
    int t;
    public List<String> addOperators(String num, int target) {
        t=target;
        result = new ArrayList<>();
        helper(num,new StringBuilder(),0,0,0);
            return result;
    }
    
    private void helper(String num , StringBuilder sb, long calc,int index,long tail){
        
        if(index==num.length()){
            if(calc==t){
            result.add(new String(sb.toString()));}
            return;
        }
        
        for(int i=index;i<num.length();i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index!=i && num.charAt(index)=='0') break;
            int len = sb.toString().length();
            if(index==0){
                sb.append(curr);
                helper(num,sb,curr,i+1,curr);
                sb.setLength(len);
            }
            else
            {
                //Add
                sb.append('+');
                sb.append(curr);
                helper(num,sb,calc+curr,i+1,curr);
                sb.setLength(len);
                
                //Sub
                sb.append('-');
                sb.append(curr);
                helper(num,sb,calc-curr,i+1,-curr);
                sb.setLength(len);

                //Mul
                sb.append('*');
                sb.append(curr);
                helper(num,sb,(calc-tail)+(curr*tail),i+1,curr*tail);
                sb.setLength(len);
            }
        
        }
        
    }
}