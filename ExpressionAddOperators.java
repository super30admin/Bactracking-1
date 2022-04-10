// Time Complexity : O(n * 3^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {

    //Code 2 : backtracking

    List<String> result;

    public List<String> addOperators(String num, int target) {

        result = new ArrayList();

        if(num == null || num.length() == 0)
            return result;
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }

    //calc = calculated value
    private void helper(String num, int index, long calc, long tail, StringBuilder path, int target)
    {
        //base
        if(index == num.length()) //we have to use up all numbers
        {
            if(calc == target)
                result.add(path.toString());
            return;
        }

        //logic
        for(int i=index; i<num.length(); i++)
        {
            //preceeding 0 case
            if(num.charAt(index) == '0' && index != i)
                continue;

            long current = Long.parseLong(num.substring(index, i+1));

            //will be used by backtracking
            int len = path.toString().length();

            //forming numbers right now, no operators
            if(index == 0)
            {
                path.append(current); //action
                helper(num, i+1, current, current, path, target); //recurse
                path.setLength(len); //backtrack
            }
            else
            {
                //+ operator
                path.append("+"); //action
                path.append(current); //action
                helper(num, i+1, calc + current, current, path, target); //recurse
                path.setLength(len); //backtrack

                //- operator
                path.append("-"); //action
                path.append(current); //action
                helper(num, i+1, calc - current, -current, path, target); //recurse
                path.setLength(len); //backtrack

                //* operator
                path.append("*"); //action
                path.append(current); //action
                helper(num, i+1, calc - tail + tail * current, tail * current, path, target);//recurse
                path.setLength(len); //backtrack
            }
        }
    }
}
