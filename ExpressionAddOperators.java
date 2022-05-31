// Time Complexity : O(N^2)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ExpressionAddOperators {
    private List<String> result;
    public List<String> addOperators(String num, int target) {
        result =new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, long currSum, long tailSum, int idx, String path ){
        //base case
        if(idx==num.length()) {
            if(target == currSum) {
                result.add(path);
            }
            return;
        }

        //logic
        for(int i=idx; i<num.length();  i++)  {
            if(num.charAt(idx) == '0' && idx != i)
                break;
            //initially 1,12,123...
            long currNum =  Long.parseLong(num.substring(idx, i+1));

            if(idx  == 0) {
                helper(num,target, currNum, currNum, i+1, path+currNum);
            } else {
                //+
                helper(num,target,currSum +currNum, currNum, i+1, path + "+" + currNum);
                //-
                helper(num,target,currSum -currNum, -1*currNum, i+1, path + "-" + currNum);
                //*

                helper(num,target, currSum - tailSum + tailSum * currNum, tailSum*currNum, i+1, path + "*" + currNum);
            }
        }

    }
}
