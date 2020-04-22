// 282.

//time - O(4 ^ n)
//space - O(n) for the call stack


class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        
        //edge
        if(num == null || num.length() == 0)
        {
            return result;
        }
        
        helper(num, 0, target, "", result, 0, 0);
        return result;
    }
    
    private void helper(String num, int index, int target, String path, List<String> result, long calculatedValue, long tail) {
        //base
        if(index == num.length())
        {
            if(target == calculatedValue)
            {
                result.add(path);
                return;
            }
        }
        
        //logic
        for(int i = index; i < num.length(); i++)
        {
            if(i != index && num.charAt(index) == '0')
            {
                break;
            }
            Long current = Long.parseLong(num.substring(index, i + 1));
            if(index == 0)
            {
                //calculated value and tail are same as current when processing the first char in string
                helper(num, i + 1, target, path + current, result, current, current);
            }
            else
            {
                //update path, calculated value and tail based on operator
                //'+' -> calculated value += current, tail = current
                //'-' -> calculated value -= current, tail = -current
                //'*' -> calculated value = calculated value - tail + tail * current, tail = tail * current
                
                helper(num, i + 1, target, path + "+" + current, result, calculatedValue + current, current);
                helper(num, i + 1, target, path + "-" + current, result, calculatedValue - current, -current);
                helper(num, i + 1, target, path + "*" + current, result, calculatedValue - tail + tail * current, tail * current);
            }
        }
    }
}
