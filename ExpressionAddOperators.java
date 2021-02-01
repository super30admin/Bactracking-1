// Time Complexity : O(4^n)
// Space Complexity : O(n) , n = length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each number at index, either append the next number, take sum or subtraction. For multiplication, inorder to comply with BODMAS use the tail to calculate the correct sum.

public class ExpressionAddOperators {
    List<String> result;
    int tar;
    public List<String> addOperators(String num, int target) {

        result = new ArrayList<>();
        tar = target;
        if(num == null || num.length() == 0) return result;

        helper(num,0,0,0,new StringBuilder());
        return result;
    }

    private void helper(String num, long currSum, long tail, int index, StringBuilder path) {

        if(num.length() == index) {
            if(tar == currSum) {
                result.add(path.toString());
            }
            return;
        }

        for(int i = index; i < num.length(); i++){

            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));

            int len = path.toString().length();

            if(index == 0){
                helper(num, curr, curr, i+1, path.append(curr));
                path.setLength(len);
            } else{

                helper(num, currSum + curr, curr, i+1, path.append("+").append(curr));
                path.setLength(len);

                helper(num, currSum-curr, -curr, i+1, path.append("-").append(curr));
                path.setLength(len);

                helper(num, currSum - tail + tail * curr, tail*curr, i+1, path.append("*").append(curr));
                path.setLength(len);
            }
        }

    }
}
