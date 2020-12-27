use std::cmp::min;

pub fn nth_ugly_number(n: i64) -> i64 {
    let mut dp = vec![0; n as usize];
    dp[0] = 1;
    let mut a = 0;
    let mut b = 0;
    let mut c = 0;
    let mut i = 1usize;
    while i < n as usize {
        let mut n2 = &dp[a] * 2;
        let mut n3 = &dp[b] * 3;
        let mut n5 = &dp[c] * 5;

        dp[i] = min(min(n2, n3), n5);
        if dp[i] == n2 {
            a += 1;
        }
        if dp[i] == n3 {
            b += 1;
        }
        if dp[i] == n5 {
            c += 1;
        }
        i += 1;
    }
    dp[n as usize - 1]
}

#[test]
fn test(){
    println!("{}",nth_ugly_number(100));
    println!("{}",nth_ugly_number(1000));
    println!("{}",nth_ugly_number(10000))
}


