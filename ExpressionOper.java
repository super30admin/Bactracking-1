/*
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/
class Solution {
    List<String> ret;
    StringBuilder temp;
    int trgt ;
    public List<String> addOperators(String num, int target) {
        ret = new ArrayList<>();
        trgt = target;
        temp = new StringBuilder();
        helper(num, 0,0,0);
        return ret;
    }

    private void helper(String num, long ttl, long tail, int indx){

        if(indx == num.length() && ttl == trgt ){
            ret.add(temp.toString());
        }

        for(int i = indx; i < num.length(); i++){
            if(num.charAt(indx) == '0' && i != indx)continue;
            long cur = Long.parseLong(num.substring(indx, i+1));
            int len = temp.length();
            if(indx == 0){
                temp.append(cur);
                helper(num, cur, cur, i+1);
                temp.setLength(len);
            }
            else{
                //+
                temp.append("+");
                temp.append(cur);
                helper(num, ttl+cur, cur, i+1);
                temp.setLength(len);
                //-
                temp.append("-");
                temp.append(cur);
                helper(num, ttl-cur, -cur, i+1);
                temp.setLength(len);
                //*
                temp.append("*");
                temp.append(cur);
                helper(num, ttl-tail + tail*cur, tail*cur, i+1);
                temp.setLength(len);
            }

        }
    }
}
