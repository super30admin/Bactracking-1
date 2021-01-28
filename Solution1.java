// Time Complexity : o(3^n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<String> res;
    StringBuilder path = new StringBuilder();
    int tar;
    int len;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num == "" || num.length() == 0) return res;
        tar = target;
        len = num.length();
        helper(num, 0, 0, 0, new StringBuilder());
        return res;
    }
    private void helper(String num, int index, long calc, long tail, StringBuilder path)
    {
        //base 
        if(index == len)
        {
            if(calc == tar)
                res.add(path.toString());
            return;
        }
        //logic
        for(int i =index; i<len; i++)
        {
            if(index != i && num.charAt(index) == '0') continue;
            int len = path.toString().length();
            Long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0)
            {
                helper(num, i+1, calc + curr, curr, path.append(curr));
                path.setLength(len);
            }
            
            else {
            //+
                path.append("+");
                path.append(curr);
                helper(num, i+1, calc + curr, curr, path);
                path.setLength(len);

                //-
                path.append("-");
                path.append(curr);
                helper(num, i+1, calc - curr, -curr, path);
                path.setLength(len);

                //*
                path.append("*");
                path.append(curr);
                helper(num, i+1, calc-tail + (tail * curr), tail * curr, path);
                path.setLength(len);
            }
            
            
            
        }
    }
}