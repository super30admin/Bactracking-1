//Time Complexity - O(exonential)
//Space Complexity - O(N)
class Solution {
public:
    
    vector<string> result;

    vector<string> addOperators(string num, int target) 
    {     
        solve(num, target, 0, "", 0, 0);
        return result;
    }
    
    void solve(string num, int target, int start, string str, long sum, long last)
    {
        if(num.size() == start)
        {
            if(target == sum)
                result.push_back(str);
            return;
        }
        
        long x = 0;
        string ret = "";
        
        for(int i=start; i<num.size(); ++i)
        {
            x = x*10 + num[i]-'0';
            ret += num[i]; 
            
            if(start == 0)
                solve(num, target, i+1, str+ret, x, x);
            
            else
            {
                solve(num, target, i+1, str+"*"+ret, sum-last+x*last, x*last);
                solve(num, target, i+1, str+"+"+ret, sum+x, x);
                solve(num, target, i+1, str+"-"+ret, sum-x, -x);
            } 
            
            if(x == 0)
                break; 
        }
    }
};