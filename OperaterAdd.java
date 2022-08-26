class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,0,0,new StringBuilder(),target);
        return result;
    }
    
    private void helper(String num,int idx,long calc,long tail ,StringBuilder path, int target){
        if(idx == num.length()) {
            if(target == calc){
                result.add(path.toString());
            }
             return;
        }
        char c = num.charAt(idx);
        int len = path.length();
        for(int i = idx;i<num.length();i++){
            if(num.charAt(idx)== '0' && i!=idx) continue;
            long curr = Long.parseLong(num.substring(idx,i+1));//1 12 123 1234 :: 2 23 234 ..
            if(idx == 0){
                path.append(curr);
                helper(num,i+1,curr,curr,path,target);
                path.setLength(len);
            }else{
                path.append("+");
                path.append(curr);
                helper(num,i+1,calc+curr,+curr,path,target);
                path.setLength(len);
                
                path.append("-");
                path.append(curr);
                helper(num,i+1,calc-curr,-curr,path,target);
                path.setLength(len);
                
                path.append("*");
                path.append(curr);
                helper(num,i+1,calc-tail + tail*curr,tail*curr,path,target);
                path.setLength(len);
            }
        }
    }
}
