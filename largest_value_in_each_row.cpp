// Time Complexity : O(2^n)
// Space Complexity :  O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> ret_vect;
        int max;
        
        if(!root)
            return ret_vect;
        
        queue<TreeNode*> qnode;
        queue<int> qdepth;
        
        vector<vector<int>> trav;
        
        qnode.push(root);
        qdepth.push(0);
        
        TreeNode* temp_node;
        int temp_depth;
        
        while(!qnode.empty())
        {
            temp_node = qnode.front(); qnode.pop();
            temp_depth = qdepth.front(); qdepth.pop();
            
            if(temp_depth == trav.size())
            {
                vector<int> temp_vect;
                temp_vect.push_back(temp_node->val);
                
                trav.push_back(temp_vect);
            }
            else
            {
                trav[temp_depth].push_back(temp_node->val);
            }
            
            if(temp_node->left)
            {
                qnode.push(temp_node->left);
                qdepth.push(temp_depth+1);
            }
            
            if(temp_node->right)
            {
                qnode.push(temp_node->right);
                qdepth.push(temp_depth+1);
            }
        }
        
        // Find the Maximum in each Level
        for(int i = 0; i < trav.size(); i++)
        {
            max = INT_MIN;
            
            for(int j = 0; j < trav[i].size(); j++)
            {
                if(trav[i][j] > max)
                {
                    max = trav[i][j];
                }
            }
            ret_vect.push_back(max);
        }
        
        return ret_vect;
    }
};