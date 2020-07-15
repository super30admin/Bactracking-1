// Time Complexity : O(4^n)
// Space Complexity :O(4^n)
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this :
//understanding all four paths was a bit tricky

// Your code here along with comments explaining your approach
//1. Call recursion with 4 paths
//2. Calculate string at each path and take appropriate actions for the mention operators
//3. Take care of preceeding 0 condition.
//recursive
class Solution {
public:
    vector<string>  result;
    vector<string> addOperators(string num, int target) {
        //edge case
        if(num.length()==0) return result;
        //recurse
        string path="";
        helper(num, target, 0, path, 0 , 0 );
        return result;
    }
    void  helper(string num, int target, int index, string path, long calc, long tail ){
        //returning condition
        if(index==num.length()){
            if((int)calc== target){
                result.push_back(path);
            }
            return;
        }
        
        //logic
        for(int i =index; i<num.length(); i++){
            //preceeding 0 condition
            if(num[index]=='0' && i!=index) break;
            string temp = num.substr(index,(i+1-index)); //substr(pos,len)
            long curr = stol(temp);
            if(index==0){
              string path_temp = path+temp;
              helper(num, target, i+1, path_temp, curr, curr);
            }else{
                //+
                string path1 = path+"+"+temp;
                helper(num, target, i+1, path1, calc+curr, curr);
                //-
                string path2 = path+"-"+temp;
                helper(num, target, i+1, path2, calc-curr, -curr);
                //*
                string path3 = path+"*"+temp;
                helper(num, target, i+1, path3, calc-tail+(tail*curr), (tail*curr));
            }
        }
    }
};
//backtracking
class Solution {
public:
    vector<string>  result;
    vector<string> addOperators(string num, int target) {
        //edge case
        if(num.length()==0) return result;
        //recurse
        string path="";
        helper(num, target, 0, path, 0 , 0 );
        return result;
    }
    void  helper(string num, int target, int index, string& path, long calc, long tail ){
        //returning condition
        if(index==num.length()){
            if((int)calc== target){
                result.push_back(path);
            }
            return;
        }
        
        //logic
        for(int i =index; i<num.length(); i++){
            if(num[index]=='0' && i!=index) break;
            string temp = num.substr(index,(i+1-index)); //substr(pos,len)
            long curr = stol(temp);
            long path_len = path.length();
            if(index==0){
                //string path_temp = path+temp;
                path = path+temp;
                helper(num, target, i+1, path, curr, curr);
                path.erase(path.begin()+path_len, path.end());
            }else{
                //+
                path = path+"+"+temp;
                helper(num, target, i+1, path, calc+curr, curr);
                path.erase(path.begin()+path_len, path.end());
                //-
                path = path+"-"+temp;
                helper(num, target, i+1, path, calc-curr, -curr);
                path.erase(path.begin()+path_len, path.end());
                //*
                path = path+"*"+temp;
                helper(num, target, i+1, path, calc-tail+(tail*curr), (tail*curr));
                path.erase(path.begin()+path_len, path.end());
            }
        }
    }
};
