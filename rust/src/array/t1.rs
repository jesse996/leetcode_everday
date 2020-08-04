pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
    let mut i = 0usize;
    let mut sum = 0;
    let mut ret = 0;
    let target = k * threshold;
    while i < k as usize {
        sum += arr[i];
        i += 1;
    }
    if sum >= target {
        ret += 1;
    }
    while i < arr.len() {
        sum = sum + arr[i] - arr[i - k as usize];
        if sum >= target {
            ret += 1;
        }
        i += 1;
    }
    ret
}