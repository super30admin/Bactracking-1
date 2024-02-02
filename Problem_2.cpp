/*
 ? Problem: Expression Add Operator
 * Time Complexity : O(N*4^N) -> N = length of the num string
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <string>
#include <vector>

class Solution {
    std::vector<std::string> result;

    void helper(std::string& num, int idx, const int target, std::vector<std::string>& path, long calc, long tail, char lastOp) {
        if (idx == num.size()) {
            if (calc == target && !path.empty()) {
                result.emplace_back(path[0]); // Start with the first element
                for (int i = 1; i < path.size(); ++i) { // Concatenate the rest of the elements
                    result.back() += path[i];
                }
            }
            return;
        }

        for (int len = 1; len <= num.size() - idx; ++len) {
            std::string str = num.substr(idx, len);
            long curr = stol(str);

            if (str.size() > 1 && str[0] == '0') break; // Skip numbers with leading zeros

            if (idx == 0) {
                // First number, just recurse
                path.push_back(str);
                helper(num, idx + len, target, path, curr, curr, '#'); // No operator before the first number
                path.pop_back();
            } else {
                path.push_back("+"); path.push_back(str);
                helper(num, idx + len, target, path, calc + curr, curr, '+');
                path.pop_back(); path.pop_back();

                path.push_back("-"); path.push_back(str);
                helper(num, idx + len, target, path, calc - curr, -curr, '-');
                path.pop_back(); path.pop_back();

                path.push_back("*"); path.push_back(str);
                if (lastOp == '+' || lastOp == '-') {
                    // If the last operation was + or -, adjust the calculation for the precedence of *
                    helper(num, idx + len, target, path, calc - tail + tail * curr, tail * curr, lastOp);
                } else {
                    // If the last operation was * or there was no operation before, just multiply with tail
                    helper(num, idx + len, target, path, calc * curr, tail * curr, '*');
                }
                path.pop_back(); path.pop_back();
            }

            if (curr == 0) break; // Avoid leading zeros
        }
    }

public:
    std::vector<std::string> addOperators(std::string num, int target) {
        std::vector<std::string> path;
        helper(num, 0, target, path, 0, 0, '#'); // Initial call with placeholders
        return result;
    }
};