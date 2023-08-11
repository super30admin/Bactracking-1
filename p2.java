// Time Complexity : O(4^n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    StringBuilder path;
    public List<String> addOperators(String num, int target) {
        path = new StringBuilder();
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, int pivot, long currsum, long tail){
        //base case
        if(pivot == num.length()){
            if(currsum == target){
                result.add(path.toString());
                
            }
            return;
        }

        //logic
        //No operator for first ietartion
        if(pivot == 0){
            for(int i=pivot; i<num.length(); i++){
                //Handle leading zero
                if(num.charAt(pivot) == '0' && i != pivot){
                    continue;
                }
                currsum = Long.parseLong(num.substring(pivot, i+1));
                int l = path.length();
                //action
                path.append(currsum);
                //recurse
                helper(num, target, i+1, currsum, currsum);
                //backtrack
                path.delete(l, path.length());
            }
        } else{
            for(int i=pivot; i<num.length(); i++){
                //Handle leading zero
                if(num.charAt(pivot) == '0' && i != pivot){
                    continue;
                }
                long currnum = Long.parseLong(num.substring(pivot, i+1));
                int l = path.length();
                long temp = currsum;
                //add
                //action
                currsum = currsum + currnum;
                path.append("+" + currnum);
                //recurse
                helper(num, target, i+1, currsum, currnum);
                //backtrack
                path.setLength(l);
                currsum = temp;

                //subtract
                //action
                currsum = currsum - currnum;
                path.append("-" + currnum);
                //recurse
                helper(num, target, i+1, currsum, -1 * currnum);
                //backtrack
                path.setLength(l);
                currsum = temp;

                //multiply
                //action
                currsum = currsum - tail + tail * currnum;
                path.append("*" + currnum);
                //recurse
                helper(num, target, i+1, currsum, tail*currnum);
                //backtrack
                path.setLength(l);
                currsum = temp;
            }
        }
    }
}