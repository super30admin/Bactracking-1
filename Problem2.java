//time exponential
//space o(n) n is the length of the string
class Solution {
    List<String> res;
    int tar;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        tar = target;
        if(num == null || num.length()==0)
            return res;
        helper(num, new StringBuilder(), 0, 0, 0);
        return res;
    }
    
    private void helper(String num, StringBuilder path, int index, long calc, long tail) {
        //base case
        if(index == num.length()) {
            if(calc == tar) {
                res.add(path.toString());
                return;
            }
        }
        //logic
        for(int i=index;i<num.length();i++) {
            if(index!=i && num.charAt(index)=='0' )
                break;
            long cur = Long.parseLong(num.substring(index,i+1));
            int len = path.toString().length();
            if(index == 0) {
                path.append(cur);
                helper(num, path, i+1, cur, cur);
                path.setLength(len);
            }
            else {
                path.append("+");
                path.append(cur);
                helper(num, path, i+1, calc + cur, cur);
                path.setLength(len);
                
                path.append("-");
                path.append(cur);
                helper(num, path, i+1, calc-cur, -cur);
                path.setLength(len);
                
                path.append("*");
                path.append(cur);
                helper(num, path, i+1, calc-tail+tail*cur, tail*cur);
                path.setLength(len);
            }
        }
    }
}