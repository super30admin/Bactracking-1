/**

Time Complexity : exponential
Space Complexity : exponential
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<String>();
    int n = num.length();
    if (n == 0) return res;
    helper(num, "", res, target, 0, 0, 0);
    return res;
    }

    private void helper(String num, String path, List<String> res, int target, int start, long cur, long prev) {
    if (start == num.length()) {
        if (cur == target) res.add(path);
        return;
    }
    
    for (int i = start; i < num.length(); i++) 
    {
        if (i != start && num.charAt(start)=='0')
         break;

     
        long tempbck = Long.parseLong(num.substring(start, i+1));
        if (start == 0) 
        {
            helper(num, String.valueOf(tempbck), res, target,i+1, tempbck, tempbck);
        } 
        else 
        {
            helper(num, path + "+" + tempbck, res, target, i+1, cur+tempbck, tempbck);
            helper(num, path + "-" + tempbck, res, target, i+1, cur-tempbck, -tempbck);
            helper(num, path + "*" + tempbck, res, target, i+1, cur-prev+prev*tempbck, prev*tempbck);
        }
    }
}
    
}