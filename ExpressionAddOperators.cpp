// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
    
   
public:
    vector<string> addOperators(string num, int target) {
       vector<string> result;
        backtracking(result, num,0, target, "", 0, 0);
        return result;
    }
    
    void backtracking(vector<string>& result, string num, int index, int target , string expr, long prevSum, long prevAddition){
      
        if(index== num.size()){
            
            if (prevSum == target){
                result.push_back(expr);
                 
            }
            return;
        }
        
        
        for(int i = index; i <num.length(); i++){
            
        long curr = to_long(num.substr(index,i+1));
          
            if(num.at(index)=='0' && i != index){
                continue;
            }
        
        
        if(index == 0){
            
            backtracking(result, num, index+1, target, expr + to_string(curr), curr, curr);
        } else {
            cout<<curr<< " " << prevAddition<<endl;
            backtracking(result, num, index+1, target, expr + '+' +  to_string(curr), prevSum + curr, curr); // addition
            
             backtracking(result, num, index+1, target, expr + '-' +  to_string(curr), prevSum - curr, -curr); // subtraction
            
             backtracking(result, num, index+1, target, expr + '*' +  to_string(curr), (prevSum - prevAddition) + (prevAddition*curr), prevAddition*curr);
            
        }
            
    }
}
    
    
    long long to_long(string str){
    long long a = 0;
    for(int i = 0; i < str.length(); i++){
        a = a*10 + str[i] - '0';
    }
    return a;
}
    
};