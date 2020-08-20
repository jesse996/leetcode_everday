/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 示例1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释:
 * <p>
 * 输入不存在公共前缀。
 * 说明：
 * <p>
 * 所有输入只包含小写字母 a-z
 */
pub fn longest_common_prefix(strs: Vec<String>) -> String {
    if strs.is_empty() { return "".to_string(); }
    let mut prefix = &strs[0][..];
    for str in strs.iter() {
        while !str.starts_with(prefix) {
            if prefix.len() == 0 { return "".to_string(); }
            prefix = &prefix[0..prefix.len() - 1];
        }
    }
    prefix.into()
}