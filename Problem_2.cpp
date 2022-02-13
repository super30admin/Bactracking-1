/**
 * Time Complexity:
 * O(4^N) where N is the length of the given array. We are recursing four times
 * or we cans ay we have four options. First when our index was zero, second for 
 * addition operation, third for subtraction and fourth for multiplication.
 */

/**
 * Space Complexity:
 * O(N)
 * 
 */



/**
 * Approach:
 * We are following a backtracking approach.
 * Here we have to take care of many things.
 * The first thing we have to make sure is our result should
 * be built up on BODMAS rule. To ensure it we use concept
 * of calculated and tail value. So, tail value is the value
 * which was the last value calculated. 
 * 
 * In case of addition operation our tail value be the current value.
 * In case of subtraction operation tailevalue will be the negative of current value.
 * In case of the multiplication it will be curr*tail value.
 * 
 */

//The code ran perfectly on leetcode

class Solution {
    
public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        helper(num, "", 0, 0, 0, target, result);
        return result;
    }
    private:
    void helper(string &num, const string path, int index, long calc, long tail, int target, vector<string> &result){
        //base
        if(index == num.size()){
            if(calc == target){
                result.push_back(path);
                return;
            }
        }
        //string str = "";
        //logic
        for(int i = index; i<num.size(); i++){
            if(i != index && num[index] == '0') continue;
            long curr = stol(num.substr(index, i - index + 1));
            //cout << str << endl;
            if(index == 0){
                helper(num, path + to_string(curr), i+1, curr,  curr, target, result);
            } else {
                helper(num , path + "+" + to_string(curr), i+1, calc + curr, curr, target,result );
                 helper(num , path + "-" + to_string(curr), i+1, calc - curr, - curr, target,result );
                 helper(num , path + "*" + to_string(curr), i+1, calc - tail + tail*curr, tail*curr, target,result );
            }
            
        }
        
    }
};




class Solution {
    
public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        helper(num, "", 0, 0, 0, target, result);
        return result;
    }
    private:
    void helper(string &num,  string path, int index, long calc, long tail, int target, vector<string> &result){
        //base
        if(index == num.size()){
            if(calc == target){
                result.push_back(path);
                return;
            }
        }
        //string str = "";
        //logic
        for(int i = index; i<num.size(); i++){
            if(i != index && num[index] == '0') continue;
            long curr = stol(num.substr(index, i - index + 1));
            //cout << str << endl;
            int len = path.size();
            if(index == 0){
                path.append(to_string(curr));
                helper(num, path, i+1, curr,  curr, target, result);
                path.resize(len);
            } else {
                path.append("+");
                path.append(to_string(curr));
                helper(num , path, i+1, calc + curr, curr, target,result );
                path.resize(len);
                
                path.append("-");
                path.append(to_string(curr));
                helper(num , path, i+1, calc - curr, -curr, target,result );
                path.resize(len);
                
                path.append("*");
                path.append(to_string(curr));
                helper(num , path, i+1, calc - tail + tail*curr, tail*curr, target,result );
                path.resize(len);
                
            }
            
        }
        
    }
};