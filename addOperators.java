import java.util.*;

public class Solution {
    List<String> possibleExpressions;
    
    public List<String> addOperators(String num, int target) {
        possibleExpressions = new ArrayList<>();
        searchPossibleExpressions(num, target, new StringBuilder(), 0, 0, 0);
        return possibleExpressions;
    }

    private void searchPossibleExpressions(String num, int target, StringBuilder currentExpression, long currentTotal, long lastValue, int currentIndex){
        if(currentIndex == num.length()){
            if(currentTotal == target){
                possibleExpressions.add(currentExpression.toString());
                return;
            }
        }
        
        for(int i = currentIndex; i < num.length(); i++){
            if(i != currentIndex && num.charAt(currentIndex) == '0') break;
            
            long currentValue = Long.parseLong(num.substring(currentIndex, i + 1));
            int prevLength = currentExpression.toString().length();
            
            if(currentIndex == 0){
                currentExpression.append(currentValue);
                searchPossibleExpressions(num, target, currentExpression, currentValue, currentValue, i + 1);
                currentExpression.setLength(prevLength);
            } else {
                currentExpression.append("+").append(currentValue);
                searchPossibleExpressions(num, target, currentExpression, currentTotal + currentValue, currentValue, i + 1);
                currentExpression.setLength(prevLength);
                
                currentExpression.append("-").append(currentValue);
                searchPossibleExpressions(num, target, currentExpression, currentTotal - currentValue, -currentValue, i + 1);
                currentExpression.setLength(prevLength);
                
                currentExpression.append("*").append(currentValue);
                searchPossibleExpressions(num, target, currentExpression, currentTotal - lastValue + lastValue*currentValue, lastValue*currentValue, i + 1);
                currentExpression.setLength(prevLength);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "232";
        int target = 8;
        List<String> output = solution.addOperators(num, target);
        System.out.println(output);  // [2+3*2, 2*3+2]
    }
}
