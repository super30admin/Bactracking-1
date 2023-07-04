// Time Complexity : O(n*4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        if(num.empty() || num.size()==0) return {};
        
        f(num,target,0,0,0,"");
        return result;
    }
    void f(string num, int target, int index, long calc, long tail, string path)
    {
        //base
        if(index == num.size() && calc == target)
        {
            result.push_back(path);
            return;
        }
        
        
        //logic
        for(int i = index;i<num.size();i++)
        {
            if(num[index]=='0' && index!=i)
            {
                continue;
            }
            long curr = stol(num.substr(index,i-index+1));
            if(index == 0)
            {
                f(num, target, i+1,curr,curr,path + to_string(curr));
            }
            else
            {
                //+ operation
                f(num, target, i+1, calc + curr, curr, path + '+' + to_string(curr));
                
                // -  operation
                f(num, target, i+1, calc - curr, -curr, path + '-' + to_string(curr));
                
                //* operation
                f(num, target, i+1, calc - tail + tail*curr,tail*curr,path + '*'+to_string(curr));
            }
        }
    }
};