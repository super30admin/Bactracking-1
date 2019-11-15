/* 282. Expression Add Operators
Time Complexity:  4 different choices or 4 different recursive paths. base case is when the value of index reaches n that is the length of the nums array. 

worst case we can have O(4^N)  valid expressions.

Overall Time Complexity: O(4^n)

Space Complexity: O(n)
*/


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        //edge case
        if(num == null || num.length() == 0)
            return result;
        backtrack("", num, target, 0,0,0);
        return result;
    }

    private void backtrack(String path, String num, int target, int index, long calculated, long tail){
        //Base Case //232
        if(index == num.length()){
            if(calculated == target){
                result.add(path);
                return;
            }
        }

        //Logic
        for(int i=index; i<num.length(); i++){
            //to take care of preceeding 0 //0213, 015
            if(i != index && num.charAt(index) == '0')
                break;

            Long cur = Long.parseLong(num.substring(index, i+1)); //"105"

            //we backtrack but we dont remove anything, we dont process anything
            if(index==0){ //first level, now recurse, not actual backtracking
                backtrack(path + cur, num, target, i+1, cur, cur);
            }else{
                backtrack(path + '+' + cur, num, target, i+1, calculated+cur, cur);
                backtrack(path + '-' + cur, num, target, i+1, calculated-cur, -cur);
                backtrack(path + '*' + cur, num, target, i+1, calculated-tail + (tail * cur), tail * cur);
            }
        }
    }
}