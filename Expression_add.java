class Solution {
    List<String> result;
    int tar;
        
    public List<String> addOperators(String num, int target) {
    result= new ArrayList<>();
        
        if(num==null || num.length()==0) return result;
        
        tar=target;
        helper(num,new StringBuilder(),0,0,0);
        
        return result;    
    }
    
    private void helper(String num,StringBuilder sb ,long calc, long tail,int index){
        
        //base
        
        if(index==num.length()){
            if(calc==tar)result.add(sb.toString());
            return;
        }
        
        
        
        
        
        
        
        
        //logic
        
        
        for(int i=index;i<num.length();i++){
            
            
            if(index!=i && num.charAt(index)=='0') break;
            
            long curr= Long.parseLong(num.substring(index,i+1));
            
            
            int len= sb.toString().length();
            
            if(index==0){
                sb.append(curr);
                helper(num, sb, curr, curr,i+1);
                sb.setLength(len);
            }else{
                sb.append("+");
                sb.append(curr);
                helper(num,sb,calc+curr,+curr,i+1);
                sb.setLength(len);
                 sb.append("-");
                sb.append(curr);
                helper(num,sb,calc-curr,-curr,i+1);
                sb.setLength(len);
                 sb.append("*");
                sb.append(curr);
                helper(num,sb,calc-tail+tail*curr,tail*curr,i+1);
                sb.setLength(len);
            }
            
            
        }
        
        
        
        
        
    }
    
    
    
    
}
