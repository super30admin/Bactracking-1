// Time Complexity : exponential
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<string> result;
    int goal;
    vector<string> addOperators(string num, int target) {
        if(num.empty() || num.length() == 0){
            return result;
        }
        goal = target;
        helper(num, 0, 0, 0, "");
        return result;
    }
    void helper(string num, int index, long long calc, long tail, string path){
        //base
        if(index == num.length()){
            if(calc == goal){
                result.push_back(path);
            }
            return;
        }
        //logic
        for(int i = index; i<num.length(); i++){
            if(num[index] == '0' && index != i)
                continue;
            long curr = stol(num.substr(index, i-index+1));
            //cout<<curr<<endl;
            if(index == 0)
                helper(num, i+1, curr, curr, path + to_string(curr));
            else{
                //+
                //cout<<path + "+" + to_string(curr)<<endl;
                helper(num, i+1, calc + curr, curr, path + "+" + to_string(curr));
                //-
                //cout<<path + "-" + to_string(curr)<<endl;
                helper(num, i+1, calc - curr, -curr, path + "-" + to_string(curr));
                
                //*
                //cout<<path + "*" + to_string(curr)<<endl;
                helper(num, i+1, calc - tail + (tail * curr), tail * curr, path + "*" + to_string(curr));
               
            }
        }
    }
};
