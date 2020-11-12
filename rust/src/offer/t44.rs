pub fn find_nth_digit(n: i32) -> i32 {
    let mut n=n as i64;
    let mut start = 1i64;
    let mut digit = 1i64;
    let mut count = 9i64;
    while n as i64 > count {
        n -= count;
        start *= 10;
        digit += 1;
        count = start * digit * 9;
    }
    let num = start + (n as i64 - 1) / digit;
    let x = num.to_string().chars().nth(((n as i64 - 1) % digit) as usize).unwrap();
    x.to_digit(10).unwrap() as i32
}