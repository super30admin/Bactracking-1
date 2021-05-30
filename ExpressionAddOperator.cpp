/*

Intuition: We have to exhaust all possible combinations. 
For each number there will be 4 cases
Add it 
Subtract it
Multiply it
Leave it ( to make a multiple digit number)

//////////////////////////////////////////////
Time and space complexity is same for both patterns
Time Complexity: O(4^(N))
Space Complexity: O(H) Height of the tree.
//////////////////////////////////////////////
*/
class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        if ( num == "") return result;
        string path;
        helper(num, target, 0, 0, 0, path);
        return result;
    }
    
    void helper(string num, int target, int index, long calulated, long tail, string path){
    
        if ( index == num.size()){
            if (target == calulated){
                result.push_back(path);
                return;                
            }
        }
        for (int i = index; i < num.size(); i++){
            if(num[index] == '0' && index != i) continue;
            long currLong = (stol)(num.substr(index, i+1-index));
            string curr = num.substr(index, i+1-index);
            if ( index == 0){
                helper(num, target, i+1, currLong, currLong, path+curr);
            }
            else{
                helper(num, target, i+1, calulated + currLong, currLong, path + "+" + curr);

                helper(num, target, i+1, calulated - currLong, -currLong, path + "-" + curr);

                helper(num, target, i+1, calulated - tail + tail*currLong, tail*currLong, path + "*" + curr);
            }

        }
    
    }
};