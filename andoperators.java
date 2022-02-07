class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num,"",target,0,0,0,res);
        return res;
    }
    private void dfs(String num, String path, int target,int pos,long eval,long mult,List<String> res) {
        if(pos==num.length()) {
            if(eval==target)
                res.add(path);
        }
        for(int i=pos;i<num.length();i++) {
            if(i!=pos && num.charAt(pos)=='0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos==0) {
                dfs(num,path+cur,target,i+1,cur,cur,res);
            }else {
                dfs(num,path+"+"+cur,target,i+1,eval+cur,+cur,res);
                dfs(num,path+"-"+cur,target,i+1,eval-cur,-cur,res);
                dfs(num,path+"*"+cur,target,i+1,eval-mult+mult*cur,mult*cur,res);
            }
        }
    }
}