//Time complexity -- O(n)
//Space complexity -- o(1)
class Solution {
        List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        findString(num, target, 0, 0, 0, new StringBuilder());
        return res;
    }
    private void findString(String num, int target, long calc, long tail, int index, StringBuilder str){
        //base case
        if(index == num.length()){
            if(calc == target){
                res.add(str.toString());
            }
        }
        //logic
        for(int i=index; i<num.length(); i++){
            //if first char is 0, move to next iteration
            if(index != i && num.charAt(index) == '0') break;
            //get the current expression (no operator case)
            long curr = Long.parseLong(num.substring(index, i+1));
            //take length to backtrack, curr expression can be more then 1 length
            int currLen = str.toString().length();
            if(index == 0){
                str.append(curr); // action
                findString(num, target, curr, curr, i+1, str);
                str.setLength(currLen); // backtrack
            }
            else{
                //+ case
                str.append("+");
                str.append(curr);
                findString(num, target, calc+curr, curr, i+1, str);
                str.setLength(currLen); // backtrack
                //System.out.println(str);
                
                //- case
                str.append("-");
                str.append(curr);
                findString(num, target, calc-curr, -1 * curr, i+1, str);
                str.setLength(currLen); // backtrack
                
                //* case
                str.append("*");
                str.append(curr);
                findString(num, target, (calc-tail)+(tail*curr), tail*curr, i+1, str);
                str.setLength(currLen); // backtrack
            }
        }
    }
    
}