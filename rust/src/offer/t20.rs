use std::collections::HashMap;
use std::string::ToString;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
macro_rules! hashmap {
    ($( $key: expr => $val: expr ),*) => {{
         let mut map = ::std::collections::HashMap::new();
         $( map.insert($key, $val); )*
         map
    }}
}
pub fn is_number(s: String) -> bool {
    if s.len() == 0 {
        return false;
    }
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

pub fn is_number2(s: String) -> bool {
    //eg. _+1.1e+2_ 从左到右共9个状态，空格用_表示
    let states = [
        hashmap![' '=> 0,'s'=> 1,'d'=> 2,'.'=> 4],
        hashmap!['d'=> 2,'.'=> 4],
        hashmap!['d'=> 2,'.'=> 3,'e'=> 5,' '=> 8],
        hashmap!['d'=> 3,'e'=> 5,' '=> 8],
        hashmap!['d'=> 3],
        hashmap!['s'=> 6,'d'=> 7],
        hashmap!['d'=> 7],
        hashmap!['d'=> 7,' '=> 8],
        hashmap![' '=> 8],
    ];
    let mut p = 0;
    let mut t: char;
    for c in s.chars() {
        if c.is_ascii_digit() {
            t = 'd';
        } else if c == '+' || c == '-' {
            t = 's';
        } else if c == '.' || c == 'e' || c == 'E' || c == ' ' {
            t = c.to_ascii_lowercase();
        } else {
            t = '?';
        }
        if !states[p].contains_key(&t) {
            return false;
        }
        p = *states[p].get(&t).unwrap() as usize;
    }

    // let s=vec![('d',5),('c',1)].into_iter().collect::<HashMap<char,i32>>();

    p == 2 || p == 3 || p == 7 || p == 8
}

#[test]
fn test() {
    assert!(!is_number("ss".to_string()));
    assert!(is_number("0".to_string()));
    assert!(is_number("1e2".to_string()));
    is_number2("ss".to_string());
}
