//Time - O(4^n) n- length(num string)
//Space - O(n)
class Solution {
public:
    vector<string> ret;
    
    vector<string> addOperators(string num, int target) {
        
        findCombination(num,target,0,"",0,0);
        return ret;
        
    }
    
    void findCombination(string num, int& target, long long val, string str, long long prev, int start){
        if(target == val && start == num.size()){
            ret.push_back(str);
            return;
        }
        
        for(int i=1;i+start<=num.size();i++){
            string s = num.substr(start,i); 
            long long n = stoll(s);
            if(to_string(n).size() != s.size()) return;
            if(start==0) findCombination(num, target, n, s, n, i);
            else{
                findCombination(num,target, val + n, str+'+'+s, n, start+i);
                findCombination(num,target, val - n, str+'-'+s, -n, start+i);
                findCombination(num,target, val - prev + prev*n  , str+'*'+s, prev*n, start+i);
            }
        }
    }
};