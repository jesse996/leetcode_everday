use std::ops::Index;

// 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
pub fn is_palindrome(s: String) -> bool {
    if s.is_empty() { return true; }
    let s = s.as_bytes();
    let mut i = 0;
    let mut j = s.len() - 1;
    while i < j {
        while !(s[i] as char).is_alphanumeric() && i < j { i += 1; }
        while !(s[j] as char).is_alphanumeric() && i < j { j -= 1; }
        if (s[i] as char).to_ascii_lowercase() != (s[j] as char).to_ascii_lowercase() {
            return false;
        }
        i += 1;
        j = j.saturating_sub(1);
    }
    true
}

#[test]
fn test() {
    let s = "a.".to_string();
    is_palindrome(s);
}