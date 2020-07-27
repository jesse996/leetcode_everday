use std::string::ToString;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

pub fn is_number(s: String) -> bool {
    if s.len() == 0 { return false; }
    let mut num_seen = false;
    let mut dot_seen = false;
    let mut e_seen = false;
    let s = s.trim().chars().collect::<Vec<_>>();
    // dbg!(s[1]);

    for (i, &c) in s.iter().enumerate() {
        if c.is_ascii_digit() {
            num_seen = true;
        } else if c == '.' {
            if dot_seen || e_seen {
                return false;
            }
            dot_seen = true;
        } else if c == 'e' || c == 'E' {
            if e_seen || !num_seen {
                return false;
            }
            e_seen = true;
            num_seen = false;
        } else if c == '+' || c == '-' {
            if i != 0 && s[i - 1] != 'e' && s[i - 1] != 'E' {
                return false;
            }
        } else {
            return false;
        }
    }
    num_seen
}

#[test]
fn test() {
    assert!(!is_number("ss".to_string()));
    assert!(is_number("0".to_string()));
    assert!(is_number("1e2".to_string()));
}