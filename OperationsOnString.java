//Time complexity: O(N^3)
//Space Complexity: O(n)
//Executed on leetcode

class Solution {
    List<String> output = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        
        backtracking(num, 0, target, 0, 0, "");
        
        return output;
    }
    
    private void backtracking(String num, int index, int target, long prevStr, long prevAdd, String currStr)
    {
        if(index==num.length())
        {
            if(prevStr == target)
                output.add(currStr);    //Base condition: when all the number characters in num string are done and operation result is target, store the operation string to output list
            return;
        }
        for(int i=index;i<num.length();i++) //Getting all possible numbers from the string
        {
            long currNum = Long.parseLong(num.substring(index,i+1));
            
            if(num.charAt(index)=='0' && index!=i)//Tracking previous operation result, previous addition value and operation in string format. 
                continue;
            if(index==0)        //For multiplication we require prevStr-prevAdd+prevAdd*currNum this value gives proper operation value and prevAdd value supposed to be product with current number.
                backtracking(num,i+1, target, currNum, currNum, currStr+currNum);
            else
            {            
                backtracking(num,i+1, target, prevStr+currNum, currNum, currStr+'+'+currNum);
                
                backtracking(num,i+1, target, prevStr-currNum, -currNum, currStr+'-'+currNum);
            
                backtracking(num,i+1, target, prevStr-prevAdd+prevAdd*currNum, prevAdd*currNum, currStr+'*'+currNum);
            }
        }
    }
}