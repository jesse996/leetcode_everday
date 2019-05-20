import tables

proc lengthOfLongestSubstring(s: string): int =
    var
        ans = 0
        n = s.len
        i = 0
    var map = initTable[char, int]()
    for j in 0..<n:
        if map.hasKey(s[j]):
            i = max(i, map[s[j]]+1)
        ans = max(ans, j-i+1)
        map[s[j]] = j
    return ans

echo lengthOfLongestSubstring("szxxxxzsafs")
