
// ## Problem2
// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)


// # Example: '123'
// # Choices:
// # 1) Addition: '1+2' = 3
// #   -Add: '3+3' = 6
// #   -Sub: '3-3' = 0
// #   -Mult: '3*3' = 9 (not correct. Problem arises). For multiplication we need to adopt a slight different logic. (Calculated value so far - value that was added or subtracted) + ( value that was added or subtracted * Current value). So 3-2 + 2 * 3 = 7 which is correct.

// # 2) Subtraction: '1-2' = -1
// # 3) Multiplication: '1*2' = 2
// # 4) No operator (append operands): '12' = 12

// # Approach: Recursive

// # We have 4 choices to make for recursion call:
// # 1) Do not choose any operator and just concatenate current character value to the path and increment the index
// # 2) Choose '+', append operator and current character value to path and add the its integer value from calculated value so for. increment the index
// # 3) Choose '-', append operator and current character value to path and subtract the its integer value from calculated value so for. increment the index
// # 4) Choose '*', append operator and current character value to path and use the formula explained above to update calculated value. increment the index

// # There is an exceptional case we also need to handle for strings like '105' and target = 5
// # Now according to our logic it will give out three answers for this: '1*0+5', '1*5', '10-5'. Out of which second path is wrong because 05 is converted to 5. To solve this, we just need to add a condition where if current characted is 0 and if its index does not match with indices we will traversing ahead, we need to skip it to avoid constructing any number starting with '0'.

// # Time complexity: Exponential O(4^n)
// # Space complexity: O(4^n * k); where n = length of given array; k = maximum lenght of path 


//recursion solution
class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        if(num.size() ==0){
            return result;
        }
        helper( num, target ,"",0,0,0);
        return result;
    }
    void helper( string num, int target, string path, long calc ,long tail, int index){
        //base
        if(index==num.size() ){
            if(target == calc){
                result.push_back(path);
            }
            return;
        }
        //logic
        for(int i= index; i< num.size() ; i++){
            //105 case
            if(num[index] == '0' && index != i){
            break;
            }
            string curr = num.substr(index, i-index+1);
            long curr_int = stol(curr);
            if(index==0){
                //as initially path is empty string
                helper( num, target, path + curr, curr_int, curr_int , i+1);
            }
            else{
                //+
                helper(num, target, path + "+" + curr, calc+ curr_int, curr_int , i+1);
                //-
                helper(num, target, path + "-" + curr, calc- curr_int, -curr_int , i+1);
                //*
                helper(num, target, path + "*" + curr, calc - tail + tail*curr_int, tail*curr_int , i+1);
            }
        }
    }
};


// # Approach: Backtracking

// # In backtracking the logic remains the same. Only thing we need to do is backtrack when we hit the base case. In our case backtrack means updatinng the path by deleting the element that was added in the last call.

// # Time complexity: O(4^n)
// # Space complexity: O(k); where k = maximum lenght of path 

// # Here space complexity came down to O(n) 

//rec + backtrack solution
class Solution {
public:
    
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        
        if(num.size() ==0){
            return result;
        }
        helper( num, target ,"",0,0,0);
        return result;
    }
    
    void helper( string num, int target, string path, long calc ,long tail, int index){
        
        
        //base
        if(index==num.size() ){
            
            if(target == calc){
                result.push_back(path);
            }
            return;
        }
        
        //logic
        for(int i= index; i< num.size() ; i++){
            
            //105 case
            if(num[index] == '0' && index != i){
            continue;
            }
            
            // string curr = num.substr(index, 1);
            string curr = num.substr(index, i-index+1);
            
            long curr_int = stol(curr);
            int len = path.size();
            
            if(index==0){
                //as initially path is empty string
                path.append( curr);
                helper( num, target, path, curr_int, curr_int , i+1);
                path.resize(len);
            }
            else{
                //+
                path.append("+");
                path.append(curr);
                helper(num, target, path , calc+ curr_int, curr_int , i+1);
                path.resize(len);
                
                //-
                path.append("-");
                path.append(curr);
                helper(num, target, path , calc- curr_int, -curr_int , i+1);
                path.resize(len);
                
                //*
                path.append("*");
                path.append(curr);
                helper(num, target, path , calc - tail + tail*curr_int, tail*curr_int , i+1);
                path.resize(len);
            }
        }
    }
};