class Solution {

    vector<string> result;
public:
    vector<string> addOperators(string num, int target) {
        
        helper(num,target,0,"",0,0);
        return result;
    }

    public:

    void helper(string num, int target, int pivot, string path, long calc, long tail)
    {
        if(pivot == num.length() && calc == target)
        {
            result.push_back(path);
        }

        for(int i = pivot; i<num.length(); i++)
        {
            if(i != pivot && num.at(pivot) == '0')
            continue;

            long curr = long(num.substr(pivot, i+1));
            
                if(pivot == 0)
                {
                    helper(num,target, i+1 , path + curr, curr, curr);
                }
                else
                {
                    //+
                    helper(num,target, i+1, path+"+"+curr, calc + curr, curr);

                    //-
                    helper(num,target, i+1, path+"-"+curr, calc - curr, -curr);

                    //*
                    helper(num,target, i+1, path+"*"+curr, calc - tail +(tail * curr), tail*curr);

                }
            
        }
    }
};