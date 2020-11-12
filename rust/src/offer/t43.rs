pub fn count_digit_one(n: i32) -> i32 {
    let mut res = 0;
    let mut cur = n % 10;
    let mut high = n / 10;
    let mut low = 0;
    let mut digit = 1;
    while cur != 0 || high != 0 {
        if cur == 0 {
            res += high * digit;
        } else if cur == 1 {
            res += high * digit + low + 1;
        } else {
            res += (high + 1) * digit;
        }
        low += cur * digit;
        cur = high % 10;
        high /= 10;
        digit *= 10;
    }
    res
}