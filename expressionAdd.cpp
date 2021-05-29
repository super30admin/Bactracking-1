// Time Complexity :O(n*4^n) where n is the length of num  
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    vector<string> result;
public:
    vector<string> addOperators(string num, int target) {
        if(num.size() == 0) return result;
        helper(num, target, 0, 0, "", 0);
        return result;
    }
    void helper(string num, int target, long calc, long tail,string path, int index){
        //base
        //cout<<index <<" "<< calc<<endl;
        if(index == num.size()){
            if(target == calc){
                result.push_back(path);
                return;
            } 
        }
        //logic
        //cout<<path<<endl;
        for(int i=index; i< num.size(); i++){
            if(num[index] == '0' && index != i) continue;
            long curr = stol(num.substr(index,i-index+1));
            if(index == 0){
                helper(num,target,curr,curr,path + to_string(curr), i+1);
            }
            else{
                //+ case
                helper(num, target, calc + curr, curr, path + '+' + to_string(curr),i+1);
                //- case
                helper(num, target, calc - curr, -curr, path + '-' + to_string(curr),i+1);
                //* case
                helper(num, target, calc - tail + tail * curr, tail * curr, path + '*' + to_string(curr),i+1);
            }
        }
        
    }
};