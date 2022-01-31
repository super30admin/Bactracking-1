// Time Complexity : O(2^(m+n)), n is length of string and m is target
// Space Complexity : O(n), n is length of given input string
// Did this code successfully run on Leetcode : yes



class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0)
            return null;
        result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(num,0,target,0,0,path);
        return result;
    }
    
    private void helper(String num,int index,int target,long calc,long tail,StringBuilder path){
        
        //base
        if(index == num.length()){
            if(target == calc){
                result.add(path.toString());
            }
            return;
        }
        
        
        //logic
        for(int i=index;i<num.length();i++){
            Long curr = Long.parseLong(num.substring(index,i+1));
             int len = path.toString().length();
            
            if(i!= index && num.charAt(index) == '0')
                continue;
            
            if(index == 0){
                path.append(curr);
                helper(num,i+1,target,curr,curr,path);
                path.setLength(len);
            }else{
               
                 //+
                path.append("+");
                path.append(curr);
                helper(num,i+1,target,calc+curr,curr,path);
                path.setLength(len);

                //-
                path.append("-");
                path.append(curr);
                helper(num,i+1,target,calc-curr,-curr,path);
                path.setLength(len);

                //*
                path.append("*");
                path.append(curr);
                helper(num,i+1,target,(calc-tail)+(curr*tail),(curr*tail),path);
                path.setLength(len);
            }
           
        }
    }
}