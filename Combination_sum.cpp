//problem can be solved with 01 recursion backtrack or forloop based back track recursion
//for loop based recursion (we can backtrack or we can send a new list at every node)
class Solution {
vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0)return result;
        helper(candidates, target,0,vector<int >());
        return result;
    }
private:
    void helper(vector<int>& candidates, int target, int pivot, vector<int> path){
        //base case 
        if(target<0)return;
        if(target==0){
            result.push_back(path);
            return;
        }
        //logic(forloop based recursion)
        for(int i = pivot; i<candidates.size();i++){ //here if we use i=0, we will be getting all the permutations as well.
            //action
            //vector<int> copypath; // if we don't back track, we would have to send a new list every time into the recursion
            //copypath = path;
            //copypath.push_back(candidates[i]);
            path.push_back(candidates[i]);
            //recurse
            helper(candidates, target-candidates[i], i, path);//here if we use i+1 we will be using that element only once just likeif we can use a coin only once kind of scenario
            //backtrack
           path.pop_back();
        }
    }   
};
