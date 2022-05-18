// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Perform exhaustive search with all possible expressions. If calculated value becomes equals to targer sum and index is equals to input vector size 
 * then add the current expression in solutions vector.
 * Current calculated value (cal) and tail value is passed while calling recursive helper method, these values are required to optimally compute next level expression value. 
 * 
 * Backtracking :- When calling a helper method add operator and current number in expr string and when it comes out of helper method remove the added number and operator from expr string.
 */

class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        if (num.empty())
            return result;
        
        string expr = "";
        helper(num, target, 0, 0, 0, expr);
        return result;
    }
    
    void helper(string& num, int target, long cal, long tail, int index, string& expr)
    {
        if (index == num.size())
        {
            if (cal == target)
            {
                result.push_back(expr);
            }
            return;
        }
        for (int i = index; i < num.size(); i++)
        {
            // Leading zeros case.
            if (num[index] == '0' && i != index)
                continue;
            
            int len = expr.length();
            long number = stol(num.substr(index, i - index + 1));
            
            if (index == 0)
            {
                expr += to_string(number);
                helper(num, target, number, number, i + 1, expr);
                expr.resize(len);
            }
            else
            {
                expr += "+" + to_string(number);;
                helper(num, target, cal + number, number, i + 1, expr);
                expr.resize(len);
                
                expr += "-" + to_string(number);;
                helper(num, target, cal - number, -number, i + 1, expr);
                expr.resize(len);
              
                expr += "*" + to_string(number);;
                helper(num, target, (cal - tail) + (tail * number), (tail * number), i + 1, expr);
                expr.resize(len);
            }
        }
    }
};