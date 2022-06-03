//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes


class Solution {
    int n;
    String num;
    List<String> list;
    public List<String> addOperators(String num, int target) {
        n = num.length();
        this.num = num;
        list = new ArrayList<>();
        if(n>0){
            f(0,target,1,1,num.charAt(0)-'0',"" + num.charAt(0));
        }
        return list;
    }

    void f(int i,long target,int c,long x,long y,String expr){
        if(i==n-1){
            if(target == c*x*y){
                list.add(expr);
            }
            return;
        }
        int p = num.charAt(i+1) - '0';
        long prd = y*x;
        f(i+1,target             ,c,prd,p,expr + "*" + num.charAt(i+1));
        f(i+1,target - prd*c,1,    1,p,expr + "+" + num.charAt(i+1));
        f(i+1,target - prd*c,-1,   1,p,expr + "-" + num.charAt(i+1));
        if(y!=0){
            f(i+1,target, c,x, 10*y + p,expr + num.charAt(i+1));
        }
    }
}