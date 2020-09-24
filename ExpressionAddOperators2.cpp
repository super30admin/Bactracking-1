// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
    
   
public:
    vector<string> res;
long long to_long(string str){
    long long a = 0;
    for(int i = 0; i < str.length(); i++){
        a = a*10 + str[i] - '0';
    }
    return a;
}

void add(string& num,int st,int& target,long long sum, long long prev,string str){
    if(st >= num.length()){
        if(target == sum){res.push_back(str);}
        return;
    }
    for(int i = st; i < num.length(); i++){
        string temp = num.substr(st,i-st+1);
        if(temp.length() > 1 && temp[0] == '0'){break;}
        long long a = to_long(temp);
        if(str.length() == 0){
            add(num,i+1,target,a,a,to_string(a));
        }
        else{
            add(num,i+1,target,sum + a,a,str + "+" + to_string(a));
            add(num,i+1,target,sum - a,-a,str + "-" + to_string(a));
            add(num,i+1,target,(sum - prev) + prev*a,prev*a,str + "*" + to_string(a));
        }
    }
}

vector<string> addOperators(string num, int target) {
    if(num.length() == 0){return res;}
    add(num,0,target,0,0,"");
    return res;
}
    
};