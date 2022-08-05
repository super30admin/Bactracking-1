// Time Complexity : O(N * 4^N), as we consider exactly 4 different choices or 4 different recursive paths for every index till N. The base case is when the value of index reaches N i.e. the length of the nums array.
// Space Complexity : O(N), the space used up by the recursion stack would be O(N) since the size of recursion stack is determined by the value of index and it goes from 0 all the way to N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ExpressionAddOperators {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        //base case
        if(num == null || num.length() == 0) return result;

        helper(num, target, 0, "", 0, 0);
        return result;
    }

    private void helper(String num, int target, int index, String path, long calc, long tail) {

        //if the index reaches num length and target is reached, add the path to the result
        if(index == num.length() && calc == target) {
            result.add(path);
            return;
        }


        for(int i=index; i<num.length(); i++) {
            //for test case 105 (leading zeros must be removed, it should not be 1 * 05)
            //but it can be 1*0*5 so check (index != i)
            if(num.charAt(index) == '0' && index != i) continue;

            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0) {
                //combine the numbers i.e., it can be 234 of 234567, then 234 + 5 ...
                //or 2+345+6 (for combining 345)
                helper(num, target, i+1, path + curr, curr, curr);
            }
            else {
                //'+' operation
                helper(num, target, i+1, path + "+" + curr, calc+curr, curr);

                //'-' operation
                helper(num, target, i+1, path + "-" + curr, calc-curr, -curr);

                //'*' operation
                helper(num, target, i+1, path + "*" + curr, (calc-tail)+(tail*curr), tail*curr);
            }
        }

    }
}