/**

    nextVal         tail
+   prevVal+num     num
-   prevVal-num     -num
*   (prevVal - tail)    tail * num
    + tail * num
    
    indexInnum = 3
    target = 0

**/
class Solution {
    
    List<String> results = new ArrayList<>();
    String operators = "+-*/";
    
    
    public List<String> addOperators(String num, int target) {
       
        addOperatorsHelper(num, target, Character.getNumericValue(num.charAt(0)), Character.getNumericValue(num.charAt(0)), 1, ""+num.charAt(0), 0);
        return results;
    }
    
    private void addOperatorsHelper(String num, int target, int prevVal, int tail, int indexInNum, String result, int runningSum)
    {
        // base case
        if (indexInNum == num.length())
        {
            if (target == runningSum)
            {
                String temp = result;
                results.add(temp);
            }
            
            return;
        }
        
        // calculate prevVal
        // all options 
        for (int i=0; i<operators.length(); i++)
        {
            int charNum = Character.getNumericValue(num.charAt(indexInNum));
            char op = operators.charAt(i);
            
            if (op == '+')
            {
                prevVal +=charNum;
                tail = charNum;
            }
            else if (op == '-')
            {
                prevVal -= charNum;
                tail = -charNum;
            }
            else if (op == '*')
            {
                prevVal = (prevVal - tail) + (tail * charNum);
                tail = tail * charNum;
            }
            else
            {
                prevVal = Integer.parseInt(prevVal+""+num.charAt(indexInNum));
                tail = prevVal;
            }
            
            result = result + op + num.charAt(indexInNum);
            System.out.println("result:"+result);
            
            addOperatorsHelper(num, target, prevVal, tail, indexInNum + 1, result, prevVal);
            result = result.substring(0, result.length()-2);
        }
    }
}
