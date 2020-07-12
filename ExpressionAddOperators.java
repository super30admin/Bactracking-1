// Time Complexity : O(3^n) n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Recursion
//4 options : +, -, * and do nothing
class Solution {
    //declare result globally
    List<String> result;
    //targ to use in recursive method
    int targ;
    public List<String> addOperators(String num, int target) {
        //initialize result
        result = new ArrayList<>();
        //set targ to target
        targ = target;
        //call recursive method with parameters
        //num string, temp string (calculated equation upto index), value of temp string, 
        //value of tail (last calc part in temp string) and index position in num string
        recursive(num,"", 0, 0, 0);
        //return final result list
        return result;        
    }
    
    private void recursive(String num, String tempOutput, long calculated, long tailValue,int index) {       
        //base case
        //if index is = num.length(), we have iterated through all the numbers in string 
        //and added different combinations of operators
        if(index == num.length()) {
            //check if calculated value is equal to target
            //if equal add tempOutput (equation) to result and return 
            if(calculated == targ) {
                result.add(tempOutput);
                return; 
            }
        }   
        //logic
        //for each index value, starting from index to end of string do
        for(int i = index; i < num.length(); i++) {
            //check if number at index is 0 (preceding 0, so i != index)
            //if i= index (only single 0 which is not ignored, it has no preceding zero)
            //if index is 0 and i!=0, say i=5 (string = 05 ~ 5, zero gets ignored)
            //to avoid this break the loop here
            if(i != index && num.charAt(index) == '0') break; 
            //take the curr number from the string (eg : 1234) (curr number (depends on i) : 1, 12, 123, 1234 )
            //this takes care of no operator condition (no operator condition)
            long curr = Long.parseLong(num.substring(index, i+1));
            //if index = 0, index points to first number, then just call recursive function on the number
            //it will have no preceding operator
            if(index == 0) {
                recursive(num, tempOutput+curr, curr, curr, i+1);
            }
            //else : 4 options : +, -, *
            //call recursive method on each 
            else {
                //for addition :
                //tempOutput String : prev "tempOutput "+" curr"
                //calulated value : prev calculated value + curr value
                //tail value(changes made in this recursive call) : +curr 
                //we remove change in next recursive call (to avoid miscalculation due to Bodmas)
                //index : i+1
                recursive(num, tempOutput+"+"+curr, calculated+curr, curr, i+1);
                
                //for subtraction :
                //tempOutput String : prev "tempOutput "-" curr" 
                //calulated value : prev calculated value - curr value
                //tail value(changes made in this recursive call) : -curr
                //we remove this change in next recursive call (to avoid miscalculation due to Bodmas)
                //index : i+1
                recursive(num, tempOutput+"-"+curr, calculated-curr, -curr, i+1);
                
                //for multiplication :
                //tempOutput String : prev "tempOutput "*" curr"
                //calulated value : (prev calculated val - prev tailValue) + (prev tailValue * curr)
                //to avoid change in value due to Bodmas
                //tail value(changes made in this recursive call) : tailValue * curr  
                //we remove this change in next recursive call (to avoid miscalculation due to Bodmas)
                //index : i+1
                recursive(num, tempOutput+"*"+curr, calculated-tailValue+tailValue*curr, tailValue*curr, i+1);               
            }
        }
    }
}


//////////////////


//Solution : Backtrack
//4 options : +, -, * and do nothing
class Solution {
    //declare result globally
    List<String> result;
    //targ to use in backtrack method
    int targ;
    public List<String> addOperators(String num, int target) {
        //initialize result
        result = new ArrayList<>();
        //set targ to target
        //if num is null or length = 0 return [] (backtrack returns : [""])
        if(num == null || num.length() == 0) return result;
        targ = target;
        //call backtrack method with parameters
        //num string, StringBuilder (mutatable string to backtrack) (calculated equation upto index), value of temp string, 
        //value of tail (last calc part in temp string) and index position in num string
        backtrack(num,new StringBuilder(), 0, 0, 0);
        //return final result list
        return result;        
    }
    
    private void backtrack(String num, StringBuilder tempOutput, long calculated, long tailValue,int index) {       
        //base case
        //if index is = num.length(), we have iterated through all the numbers in string 
        //and added different combinations of operators
        if(index == num.length()) {
            //check if calculated value is equal to target
            //if equal add tempOutput (equation, convert to string and add) to result and return 
            if(calculated == targ) {
                result.add(tempOutput.toString());
                return; 
            }
        }   
        //logic
        //for each index value, starting from index to end of string do
        for(int i = index; i < num.length(); i++) {
            //check if number at index is 0 (preceding 0, so i != index)
            //if i= index (only single 0 which is not ignored, it has no preceding zero)
            //if index is 0 and i!=0, say i=5 (string = 05 ~ 5, zero gets ignored)
            //to avoid this break the loop here
            if(i != index && num.charAt(index) == '0') break; 
            //take the curr number from the string (eg : 1234) (curr number (depends on i) : 1, 12, 123, 1234 )
            //this takes care of no operator condition (no operator condition)
            long curr = Long.parseLong(num.substring(index, i+1));
            //if index = 0, index points to first number, then just call backtrack function on the number
            //it will have no preceding operator
            //set len to backtrack (remove last inserted operation and number)
            int lenBackTrack = tempOutput.toString().length();
            if(index == 0) {
                tempOutput.append(curr);
                backtrack(num, tempOutput, curr, curr, i+1);
                tempOutput.setLength(lenBackTrack);
            }
            //else : 4 options : +, -, *
            //call backtrack method on each 
            else {
                //for addition :
                //tempOutput : prev "tempOutput "+" curr"
                //so append + and then curr to stringBuilder
                //calulated value : prev calculated value + curr value
                //tail value(changes made in this backtrack call) : +curr 
                //we remove change in next backtrack call (to avoid miscalculation due to Bodmas)
                //index : i+1
                //we set len back to len before appending operator and number (backtrack operation)
                tempOutput.append("+");
                tempOutput.append(curr);
                backtrack(num, tempOutput, calculated+curr, curr, i+1);
                tempOutput.setLength(lenBackTrack);
                
                //for subtraction :
                //tempOutput : prev "tempOutput "-" curr" 
                //so append - and then curr to stringBuilder
                //calulated value : prev calculated value - curr value
                //tail value(changes made in this backtrack call) : -curr
                //we remove this change in next backtrack call (to avoid miscalculation due to Bodmas)
                //index : i+1
                //we set len back to len before appending operator and number (backtrack operation)
                tempOutput.append("-");
                tempOutput.append(curr);
                backtrack(num, tempOutput, calculated-curr, -curr, i+1);
                tempOutput.setLength(lenBackTrack);
                
                //for multiplication :
                //tempOutput : prev "tempOutput "*" curr"
                //so append * and then curr to stringBuilder
                //calulated value : (prev calculated val - prev tailValue) + (prev tailValue * curr)
                //to avoid change in value due to Bodmas
                //tail value(changes made in this backtrack call) : tailValue * curr  
                //we remove this change in next backtrack call (to avoid miscalculation due to Bodmas)
                //index : i+1
                //we set len back to len before appending operator and number (backtrack operation)
                tempOutput.append("*");
                tempOutput.append(curr);
                backtrack(num, tempOutput, calculated-tailValue+tailValue*curr, tailValue*curr, i+1); 
                tempOutput.setLength(lenBackTrack);
            }
        }
    }
}

