class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        //string,target,index,calc,tail,path
        helper(num,target,0,0,0,new StringBuilder());
        return result;
    }
    
    public void helper(String num,int target,int index,long calc,long tail,StringBuilder sb){
        //base
        if(index==num.length()){
            if(calc == target)
                result.add(sb.toString());
            return; 
        }
        
        //logic
        for(int i=index;i<num.length();i++){
            if(num.charAt(index)=='0' && i!=index)
                break;
            Long curr = Long.parseLong(num.substring(index,i+1));
            int len=sb.toString().length();
            if(index==0){
                sb.append(curr);
                helper(num,target,i+1,curr,curr,sb);
                sb.setLength(len);
            }else{
                //+
                sb.append("+");
                sb.append(curr);
                helper(num,target,i+1,calc+curr,curr,sb);
                sb.setLength(len); 
                //-
                sb.append("-");
                sb.append(curr);
                helper(num,target,i+1,calc-curr,-curr,sb);
                sb.setLength(len); 
                //*
                sb.append("*");
                sb.append(curr);
                helper(num,target,i+1,calc-tail+tail*curr,tail*curr,sb);
                sb.setLength(len); 
            }
        }
        
        
    }
    
}