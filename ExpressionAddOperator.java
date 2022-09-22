// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Recursion and backtracking. Take substring from index to i each time, Maintain tail,
for multiplication--> calc value== (calc-tail)+(tail*curr)
whenever the calc value== target add the expression to result
* */
public class ExpressionAddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result= new ArrayList<>();

        helper(num,target,0,0,0,new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int index, long tail,long calc,StringBuilder path){
        if(index==num.length() && calc==target) {
            result.add(path.toString());
            return;
        }

        for(int i=index;i<num.length();i++){
            if(i!=index && num.charAt(index)=='0') continue;

            long curr= Long.parseLong(num.substring(index,i+1));
            int len= path.length();
            if(index==0){
                path.append(curr);
                helper(num,target,i+1,curr,curr,path);
                path.setLength(len);
            }else{
                path.append("+");
                path.append(curr);
                helper(num,target,i+1,curr,calc+curr,path);
                path.setLength(len);

                path.append("-");
                path.append(curr);
                helper(num,target,i+1,-curr,calc-curr,path);
                path.setLength(len);

                path.append("*");
                path.append(curr);
                helper(num,target,i+1,(tail*curr),(calc-tail)+(tail*curr),path);
                path.setLength(len);
            }
        }
    }
}
