//
// Created by jesse on 2021/1/5.
//

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//示例: 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#include <string>
#include <vector>
#include <sstream>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Codec {
public:

    // Encodes a tree to a single string.
    //1。前序遍历
    string serialize(TreeNode *root) {
        vector<string> res;
        serialize(root, res);
        string s;
        for (const auto &a:res) {
            s += a;
        }
        return s;
    }

    void serialize(TreeNode *root, vector<string> res) {
        if (!root) {
            res.emplace_back("#");
            res.emplace_back(",");
            return;
        }
        res.push_back(to_string(root->val));
        res.emplace_back(",");
        serialize(root->left, res);
        serialize(root->right, res);
    }

    // Decodes your encoded data to tree.
    TreeNode *deserialize(string data) {
        stringstream ss(data);
        std::string item;
        queue<string> q;
        while (std::getline(ss, item, '_'))
            q.push(item);
        return deserialize(q);
    }

    TreeNode *deserialize(queue<string> q) {
        if (q.empty()) {
            return nullptr;
        }
        string first = q.front();
        q.pop();
        if (first == "#") {
            return nullptr;
        }
        auto root = new TreeNode(stoi(first));
        root->left = deserialize(q);
        root->right = deserialize(q);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));