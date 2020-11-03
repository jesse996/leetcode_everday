// 输入一个字符串，打印出该字符串中字符的所有排列。
//
//  
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//  
//
// 示例:
//
// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]
//
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

use std::collections::HashSet;
use std::mem::swap;


pub  fn permutation(s: String) -> Vec<String> {
    let mut chars:Vec<char> = s.chars().collect();
    let mut res = vec![];
    chars = s.chars().collect();
    dfs(0,&mut chars,&mut res);

    res
}

fn dfs(x:usize, chars: &mut Vec<char>, res:&mut Vec<String>){
    let len = chars.len();
    if x== len{
        // let s=String::from_iter(chars);
        let s: String = chars.iter().collect();
        res.push(s);
        return;
    }
    let mut set = HashSet::new();
    for i in x..len {
        if set.contains(&chars[i]) { continue; };
        set.insert(chars[i]);
        chars.swap(i, x);
        dfs(x + 1,  chars,  res);
        chars.swap(i, x);
    };
}