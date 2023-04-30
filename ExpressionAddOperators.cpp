// Time Compelxity - O(l*4^l), l is the length of string "num", multiplied by l because we are creating a substring at every point.
// Space Complexity - O(l)
class Solution {
    void helper(string num, int target, int idx, string curr, long calc, long tail, vector<string>& expr){
        // base
        if(idx == num.length()){
            if(calc == target)
                expr.push_back(curr);
            return;
        }
        
        // logic
        int l = curr.length();
        for(int i = idx; i < num.length(); i++){
            if(num[idx] == '0' && i != idx)
                continue;
            string str = num.substr(idx, i - idx + 1);
            long n = stol(str);
            if(idx == 0){
                curr += str;
                helper(num, target, i+1, curr, calc + n, n, expr);
                curr.resize(l);
            }
            else{
                // case '+'
                curr += '+';
                curr += str;
                helper(num, target, i+1, curr, calc + n, n, expr);
                curr.resize(l);

                // case '-'
                curr += '-';
                curr += str;
                helper(num, target, i+1, curr, calc - n, -n, expr);
                curr.resize(l);

                // case '*'
                curr += '*';
                curr += str;
                helper(num, target, i+1, curr, calc - tail + tail*n, tail*n, expr);
                curr.resize(l);
            }
        }
    }
public:
    vector<string> addOperators(string num, int target) {
        vector<string> expr;
        helper(num, target, 0, "", 0, 0, expr);
        return expr;
    }
};