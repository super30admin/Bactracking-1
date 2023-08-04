class Solution {
public:
    unordered_map<string, bool> memo;
    vector<string> result;
    
    void backtrack(string num, int target, int index, long currentSum, long prevNum, string currentExpr) {
        if (index == num.length()) {
            if (currentSum == target) {
                result.push_back(currentExpr);
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            string currentStr = num.substr(index, i - index + 1);
            
            if (currentStr.length() > 1 && currentStr[0] == '0') {
                // Avoid leading zeros
                break;
            }
            
            long currentNum = stol(currentStr);
            
            if (index == 0) {
                backtrack(num, target, i + 1, currentNum, currentNum, currentExpr + currentStr);
            } else {
                // '+'
                backtrack(num, target, i + 1, currentSum + currentNum, currentNum, currentExpr + "+" + currentStr);
                
                // '-'
                backtrack(num, target, i + 1, currentSum - currentNum, -currentNum, currentExpr + "-" + currentStr);
                
                // '*'
                backtrack(num, target, i + 1, currentSum - prevNum + prevNum * currentNum, prevNum * currentNum, currentExpr + "*" + currentStr);
            }
        }
    }
    
    vector<string> addOperators(string num, int target) {
        backtrack(num, target, 0, 0, 0, "");
        return result;
    }
};