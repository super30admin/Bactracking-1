// Time Complexity : O(3^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num == null || num.length() == 0){
            return res;
        }
        helper(num,target,0,"",0,0);
        return res;
    }
    void helper(String num,int target, int index, String path, long cal, long tail){
        if(index == num.length()){
            if(cal == target){
                res.add(path);
            }
            return;
        }
        
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index) == '0') continue;
            long cur = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,target,i+1,path+cur,cur,cur);
            }
            else {
                helper(num,target,i+1, path+'+'+cur,cal+cur,cur);
                helper(num,target,i+1, path+'-'+cur,cal-cur,-cur);
                helper(num,target,i+1, path+'*'+cur,cal-tail+tail*cur,tail*cur);
            }
        }
    }
}