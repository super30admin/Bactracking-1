/**
Time Complexity : Exponential
Space Complexity : O(D), D = depth of the recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    private List<String> output;

    public List<String> addOperators(String num, int target)
    {
        this.output = new ArrayList<>();

        expressionAddOperators(num, 0, 0, target , 0, "");
        return this.output;
    }

    private void expressionAddOperators(String nums, long calc, long tail, int target, int index, String path)
    {
        // base case
        if(index == nums.length() && target == calc)
        {
            this.output.add(path);
        }

        if(index == nums.length())
            return;
        
        // logic
        for(int i = index; i < nums.length(); i++)
        {
            // taking the current number from the index and current i
            long current = Long.parseLong(nums.substring(index, i + 1));
            
            if(nums.charAt(index) == '0' && index != i)
                continue;

            if(index == 0)
            {
                expressionAddOperators(nums, current, current, target, i + 1, path + current);
            }
            else
            {

                // +
                expressionAddOperators(nums, calc + current, current, target, i + 1, path + "+" + current);

                // -
                expressionAddOperators(nums, calc - current, -current, target, i + 1, path + "-" + current);

                // *
                expressionAddOperators(nums, calc - tail + tail*current, tail * current, target, i + 1, path + "*" + current);
            }
        }
    }
}