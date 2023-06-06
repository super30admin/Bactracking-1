// TC:O(3^n);
// SC:O(3^n);

// for loop based approach
// The approach uses a recursive helper function that takes in the current number, target value, current index, calculated value, tail value, and the current expression path.

// At each index, the algorithm considers three possibilities: addition, subtraction, and multiplication. It recursively explores all combinations by updating the calculated value, tail value, and the expression path accordingly.

// The algorithm stops when it reaches the end of the string, and if the calculated value matches the target value, it adds the current expression path to the results vector.

// Overall, the approach exhaustively explores all possible combinations of operators and backtracks when necessary to find all valid expressions that reach the target value.

class Solution {
public:
    vector<string> results;
    
    vector<string> addOperators(string num, int target) {
        helper(num, target, 0, 0, 0, "");
        return results;
    }

    void helper(const string& num, const int target, int index, long long calc, long long tail, const string& path) {
        // Base case: reached the end of the string
        if (index == num.size()) {
            // Check if the calculated value matches the target
            if (calc == target) {
                // Add the current expression to the results
                results.push_back(path);
            }
            return;
        }
        
        // Calculate the current number from index to i
        long long curr = 0;
        for (int i = index; i < num.size(); ++i) {
            // Skip leading zeros (unless it's the first digit)
            if (num[index] == '0' && i > index) {
                break;
            }
            
            // Update the current number
            curr = curr * 10 + (num[i] - '0');
            
            if (index == 0) {
                // First number in the expression
                // Recurse with the updated values
                helper(num, target, i + 1, curr, curr, to_string(curr));
            } else {
                // Addition operator
                helper(num, target, i + 1, calc + curr, curr, path + "+" + to_string(curr));
                
                // Subtraction operator
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + to_string(curr));
                
                // Multiplication operator
                // To handle operator precedence, subtract the tail and then multiply the tail by the current number
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + to_string(curr));
            }
        }
    }
};
