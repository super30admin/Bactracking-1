// Time Complexity : The time complexity is O(4^n) where n is the length of the string
// Space Complexity : The space complexity is O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    List<String> output;

    public List<String> addOperators(String num, int target) {

        output = new LinkedList<>();

        if(num == null || num.length() == 0){
            return output;
        }

        backTrack(num,target,0,0,0,new StringBuilder());

        return output;

    }

    public void backTrack(String num,int target,int index,long cal,long lastCal,StringBuilder sb){

        // Base case
        if(index == num.length()){
            if(target == cal){
                output.add(sb.toString());
            }
            return;
        }

        for(int i=index;i<num.length();i++){

            // Handle cases which start with 0
            if(index != i && num.charAt(index) == '0'){
                break;
            }

            long temp = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();

            // Handle index 0
            if(index==0){
                sb.append(temp);
                backTrack(num,target,i+1,temp,temp,sb);
                sb.setLength(len);
            }
            else{
                // Addition
                sb.append('+');
                sb.append(temp);
                backTrack(num,target,i+1,cal+temp,temp,sb);
                sb.setLength(len);

                // Subtraction
                sb.append('-');
                sb.append(temp);
                backTrack(num,target,i+1,cal-temp,-temp,sb);
                sb.setLength(len);

                // Multiplication
                sb.append('*');
                sb.append(temp);
                backTrack(num,target,i+1,cal-lastCal+(lastCal*temp),lastCal*temp,sb);
                sb.setLength(len);
            }

        }
    }
}