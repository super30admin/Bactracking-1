/*
Time complexity: N*4^N at every step we have 4 choices
Time complexity: O(N)
*/
class Solution {
    List<String> result; 
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num== null || num.length()==0)
            return result;
        
        helper(num, target, 0, 0, 0 , new StringBuilder());
        return result;
    }
    private void helper(String num, int target, long calVal, long tail, int index, StringBuilder sb){
        //when to add answer to result list
        if(index == num.length()){
            if(target == calVal){
                result.add(sb.toString());  
                return;
            }
        }
        for(int i=index; i< num.length(); i++){
            //precideing zero case
            if(index != i && num.charAt(index) == '0') continue;
            
            long cur = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            
            //initial case when index is 0
            if(index ==0){
                //action
                helper(num, target, cur , cur, i+1 , sb.append(cur));
                //backtrack : set stringbuilder length to what it was before taking the cur action.
                //i.e. simply ignore what we added to path.
                sb.setLength(len);
            }
            else{
                /*At every step, we have 4 different choices:
                No operator call would simply extend cur by the current digit and move ahead; */
                
                //case 1: add + operator, just add cur digit to prev result.
                //action & recursion
                helper(num, target, calVal+cur, cur, i+1, sb.append("+").append(cur));
                //backtrack
                sb.setLength(len);
                
                //case 2: add - operator, substract cur digit val from prev result.
                //action & recursion
                helper(num, target, calVal-cur, -cur, i+1, sb.append("-").append(cur));
                //backtrack
                sb.setLength(len);
                
                //case 3: add * operator
                //nullify what we did in the prev calculation as we will have to do multiplication operation first.
                //action & recursion
                helper(num, target, calVal-tail + tail* cur , tail*cur, i+1, sb.append("*").append(cur));
                //backtrack
                sb.setLength(len);
            }     
        }
        
    }
}
