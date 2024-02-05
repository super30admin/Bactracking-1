// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Method used : Backtracking

class Solution {

    List<String> result = new ArrayList();

    public List<String> addOperators(String num, int target) {
        
        helper(num, target, 0, 0, 0, new StringBuilder());

        return result;
    }

    private void helper(String num, int target, int index, long calc, long tail, StringBuilder temp)
    {
        if(index == num.length())
        {
            if(calc == target) result.add(temp.toString());

            return;
        }

        // We have 2 levels of recursion, the 1st level with fetch the numbers from substrings and the 2nd level will
        // perform arithmetic recursive calls on thse numbers

        for(int i = index; i < num.length(); i++)
        {
            // dealing with zeros. This is important because, if we don't deal them for example in string 105 1 * 05 is treated
            // as 1 * 5 which shouldn't happen because when we parse the string 05 it parses it as 5. So we have to be sure that
            // if we have any zeros we deal with it. Assume we have a number 1005 now, if my index and i are pointing at same 
            // zero then thats not a problem because thats a valid operation and substring will also give us 0 after parsing
            // But if we have substring 07 then after parsing it becomes 7 which shouldn't happen. So we need to be safe when 
            // index is pointing to zero but i and index are not pointing to same location

            // Fetching 0 as substring is fine but fetching 05 is not allowed because it results to 5
            if(num.charAt(index) == '0' && i != index) continue;

            // dealing with numbers where index doesn't point to a zero
            
            // Converts string to an long number
            long curr = Long.parseLong(num.substring(index, i + 1));

            // We need the initial length of the string. Assume the current number is 1 and the operation to perform is 
            // 1 + 234567, then while popping we need to pop +234567, so for this we need to maintain the length
            int length = temp.length();

            // This if case is for fetching out all the numbers first, only then we apply arithmetic recursion calls on them
            if(index == 0)
            {
                // action
                temp.append(curr);

                // recurse
                // Above we already fetched the curr value, as we are at first level of recursion we just make up the numbers,
                // So the curr and tail will be same bcoz when we make arithmetic recursion calls the default previous value
                // should be curr itself.
                helper(num, target, i + 1, curr, curr, temp);

                // backtrack
                temp.setLength(length);
            }

            else
            {
                // action
                temp.append("+");
                temp.append(curr);

                // recurse
                helper(num, target, i + 1, calc + curr, curr, temp);

                // backtrack => We have set the string to it's original length
                temp.setLength(length);

                // action 
                temp.append("-");
                temp.append(curr);

                // recurse
                helper(num, target, i + 1, calc - curr, -curr, temp);

                // backtrack => We have set the string to it's original length
                temp.setLength(length);

                // action
                temp.append("*");
                temp.append(curr);

                // recurse
                // We are doing a operation here as calc - tail. Assume the string is 1 + 2 * 3, this means we have to do 
                // -2 first to the actual value. If the string was 1 - 2 * 3, then we have 1 - 2 as -1 so we should add +2
                // to revert back the changes. That's the reason we pass the tail values above in the recursive calls
                // Assume for '-' recursive call above we passe tail as -curr because when we do calc - tail it's actually
                // doing calc - (-previous curr value), so we are reverting changes by adding the number.
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, temp);

                // backtrack => We have set the string to it's original length
                temp.setLength(length);
            }

            
        }
    }
}