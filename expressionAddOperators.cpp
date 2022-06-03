
//RECURSION
TC = O(n 4^n)
SC = O(N*N)
    
At each case - we have 4 options 
and the height of recursion tree = N
and at each pass we copy path = N

Each call branches into 4 additional calls, and each call has a time complexity of O(n) which is the cost of copying a valid path to the res:
T(n) = 4T(n - 1) + O(n) which according to masters theorem gives O(n 4^n)

class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        recursion(num,"",0,0,0,target);
        return result;
    }
    
    void recursion(string num, string path, long cal, long tail,  int pivot, int target){
        //base
        if(pivot == num.length()){
            if(cal == target){
                result.push_back(path);
            }
            return;
        }
        string strCur = "";
        //logic
        for(int i=pivot; i<num.length();i++){
            strCur += num[i];
            long cur = stol(strCur); 
            //preceding zero
            if(num[pivot]=='0' && pivot!=i) continue;
            //first level - no operators
             if(pivot==0){
                 recursion(num, path+strCur, cur, cur, i+1, target);
             }else{
                 //+
                recursion(num, path+"+"+strCur, cal+cur, cur, i+1, target);
                //-
                recursion(num, path+"-"+strCur, cal-cur, -cur, i+1, target);
                //*
                recursion(num, path+"*"+strCur, cal-tail+tail*cur, tail*cur, i+1, target);
             }
        }
    }
};

//BACKTRACKING
SC = O(N)

class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        recursion(num,"",0,0,0,target);
        return result;
    }
    
    void recursion(string num, string path, long cal, long tail,  int pivot, int target){
        //base
        string copy = path;
        if(pivot == num.length()){
            if(cal == target){
                result.push_back(copy);
            }
            return;
        }
        string strCur = "";
        //logic
        for(int i=pivot; i<num.length();i++){
            strCur += num[i];
            long cur = stoll(strCur); 
            //preceding zero
            if(num[pivot]=='0' && pivot!=i) continue;
            //first level - no operators
            int length = path.length();
             if(pivot==0){
                 //action
                 path=path+strCur;
                 //recurse
                 recursion(num, path, cur, cur, i+1, target);
                 //backtrack
                 path = path.substr(0,length);
                 
             }else{
                 //+
                path=path+"+"+strCur;
                recursion(num, path, cal+cur, cur, i+1, target);
                path = path.substr(0,length);
                //-
                path=path+"-"+strCur;
                recursion(num, path, cal-cur, -cur, i+1, target);
                path = path.substr(0,length);
                //*
                path=path+"*"+strCur;
                recursion(num, path, cal-tail+tail*cur, tail*cur, i+1, target);
                path = path.substr(0,length);
             }
        }
    }
};
