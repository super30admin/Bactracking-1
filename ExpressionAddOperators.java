class Solution {
    String num;
    int target;
    StringBuilder str;
    List<String> res;
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        this.str = new StringBuilder();
        this.res = new ArrayList<>();
        backtrack(0, 0, 1);
        return res;
    }
    
    public void backtrack(int index, long sum, long tail){
        if(index == num.length()){
            if(sum == target){
                res.add(new String(str));
                return;
            }
        }
        
        for(int i=index; i<num.length(); i++){
            
            if(num.charAt(index) == '0' && i != index) 
                continue;
            
            long digit = Long.parseLong(num.substring(index, i+1)); 
            int len = str.length();
            if(index == 0){
                str.append(""+digit);
                backtrack(i+1, digit, digit);
                str.setLength(len);
            }   
            else{
                //case1: +operator
                str.append("+"+digit);
                backtrack(i+1, sum+digit, digit);
                str.setLength(len);
                //case2: -operator
                str.append("-"+digit);
                backtrack(i+1, sum-digit, digit*-1);
               str.setLength(len);
                //case3: *operator
                str.append("*"+digit);
                backtrack(i+1, (sum-tail)+(tail*digit), tail*digit);
                str.setLength(len);
            }
        }
    }
}
