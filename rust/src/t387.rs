pub fn first_uniq_char(s: String) -> i32 {
    let mut arr = [0i32; 26];
    for (i, c) in s.char_indices() {
        arr[c as usize - 'a' as usize] = i as i32;
    }
    for (i, c) in s.char_indices() {
        if i as i32 != arr[c as usize - 'a' as usize] {
            arr[c as usize - 'a' as usize] = -1;
        } else {
            return i as i32;
        }
    }
    -1
}