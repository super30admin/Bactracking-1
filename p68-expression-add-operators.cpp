// Using BackTracking
// Time complexity is O(4^n) exponential time complexity where n is length of the string
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<string> res;
    int targ;
    void helper(string num, string path, long calc, long tail, int index) {
        //base
        if(index == num.size()) {
            if(calc == targ)
                res.push_back(path);
            return;
        }
        //logic
        for(int i = index; i < num.size(); i++) {
            long curr = stol(num.substr(index, i-index+1));
            if(index != i && num[index] == '0') continue;
            if(index == 0) {
                helper(num, path + to_string(curr), curr, curr, i+1);
            }
            else {
                helper(num, path + "+" + to_string(curr), calc+curr, curr, i+1);
                helper(num, path + "-" + to_string(curr), calc-curr, -curr, i+1);
                helper(num, path + "*" + to_string(curr), calc-tail + tail*curr, tail*curr, i+1);
            }
        }
    }
    
    vector<string> addOperators(string num, int target) {
        if(num.size() == 0) return {};
        targ = target;
        helper(num, "", 0, 0, 0);
        return res;
    }
};
