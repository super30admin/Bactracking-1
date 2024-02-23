// TC = O(L * 4 ^ L); L = length of string num
// SC = O(L) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(L * 4 ^ L); L = length of string num
    // SC = O(L) 
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        helper(num, 0, 0, 0, "", target);
        return result;
    }
    void helper(string num, int idx, long calc, long tail, string path, int target) {
        // base
        if(idx == num.size()) {
            if(calc == target) result.push_back(path);
            return;
        }
        // logic
        for(int i = idx; i < num.size(); i++) {
            // preceeding zero
            if(i != idx && num[idx] == '0') continue; // 0 is ok but 05 is not
            long curr = stol(num.substr(idx, i + 1 - idx));
            int le = path.size();
            if(idx == 0) { // 1st index
                // action
                path += to_string(curr);
                // recurse
                helper(num, i + 1, curr, curr, path, target);
                // backtrack
                path.resize(le);
            }
            else {
                // +
                // action
                path += '+';
                path += to_string(curr);
                // recurse
                helper(num, i + 1, calc + curr, curr, path, target);
                // backtrtack
                path.resize(le);
                // -
                // action
                path += '-';
                path += to_string(curr);
                // recurse
                helper(num, i + 1, calc - curr, - curr, path, target);
                // backtrack
                path.resize(le);
                // *
                // action
                path += '*';
                path += to_string(curr);
                // recurse
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                // backtrack
                path.resize(le);
            }
        }
    }
};