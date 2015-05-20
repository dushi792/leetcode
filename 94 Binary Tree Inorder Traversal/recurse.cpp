vector<int> inorderTraversal(TreeNode *root) {  
      // Start typing your C/C++ solution below  
      // DO NOT write int main() function  
      vector<int> result;  
      inorderTra(root, result);  
      return result;  
    }  
    void inorderTra(TreeNode* node, vector<int> &result)  {
		if(node == NULL)  
		{        
		return;  
		}  
		inorderTra(node->left, result);  
		result.push_back(node->val);      
		inorderTra(node->right, result);  
    }  