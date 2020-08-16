import java.util.ArrayList;
import java.util.Arrays;

//public class T1044 {
//    /**
//     * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
//     * <p>
//     * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
//     * <p>
//     *  
//     * <p>
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     * 示例 1：
//     * <p>
//     * 输入："banana"
//     * 输出："ana"
//     * 示例 2：
//     * <p>
//     * 输入："abcd"
//     * 输出：""
//     */
//
//    public String longestDupSubstring(String S) {
//        int n = S.length();
//        String[] sa = new String[n];
//        for (int i = 0; i < n; i++) {
//            sa[i] = S.substring(i);
//        }
//        Arrays.sort(sa);
//        String max = "";
//        for (int i = 1; i < n; i++) {
//            int len = lcp(sa[i - 1], sa[i]);
//            if (len > max.length()) max = sa[i].substring(0, len);
//        }
//        return max;
//    }
//
//    static int lcp(String a, String b) {
//        int n = Math.min(a.length(), b.length());
//        for (int i = 0; i < n; i++) {
//            if (a.charAt(i) != b.charAt(i)) return i;
//        }
//        return n;
//    }
//
//    static int S_TYPE = 0;
//    static int L_TYPE = 1;
//
//    static int[] buildType(String S) {
//        int n = S.length();
//        int[] type = new int[n + 1];
//        //确定后缀类型
//        type[n] = S_TYPE;
//        type[n - 1] = L_TYPE;
//        for (int i = n - 2; i >= 0; i--) {
//            if (S.charAt(i) > S.charAt(i + 1)) type[i] = L_TYPE;
//            else if (S.charAt(i) < S.charAt(i + 1)) type[i] = S_TYPE;
//            else type[i] = type[i + 1];
//        }
//        return type;
//    }
//
//    static boolean isLMSChar(int offset, int[] type) {
//        if (offset == 0) return false;
//        return type[offset] == S_TYPE && type[offset - 1] == L_TYPE;
//    }
//
//    static void showTypeMap(String data) {
//        int[] type = buildType(data);
//        System.out.println(data);
//        Arrays.stream(type).forEach(s -> {
//            if (s == 0) {
//                System.out.print("S");
//            } else {
//                System.out.print("L");
//            }
//        });
//        System.out.println();
//        for (int i = 0; i < type.length; i++) {
//            if (isLMSChar(i, type)) {
//                System.out.print("^");
//            } else {
//                System.out.print(" ");
//            }
//        }
//
//    }
//
//    static boolean lmsSubstringsAreEquql(String s, int[] type, int offset1, int offset2) {
//        if (offset1 == s.length() || offset2 == s.length()) return false;
//        int i = 0;
//        while (true) {
//            boolean aIsLMS = isLMSChar(i + offset1, type);
//            boolean bIsLMS = isLMSChar(i + offset2, type);
//            if (i > 0 && aIsLMS && bIsLMS) return true;
//            if (aIsLMS != bIsLMS) return false;
//            if (s.charAt(i + offset1) != s.charAt(i + offset2)) return false;
//            i += 1;
//        }
//    }
//
//    static int[] findBucketSizes(char[] s) {
//        int SIGMA = 256;
//        int[] ret = new int[SIGMA];
//        for (char c : s) {
//            ret[c] += 1;
//        }
//        return ret;
//    }
//
//    static int[] findBucketSizes(char[] s, int SIGMA) {
//        int[] ret = new int[SIGMA];
//        for (char c : s) {
//            ret[c] += 1;
//        }
//        return ret;
//    }
//
//    static int[] findBucketHeads(int[] bucketSizes) {
//        int offset = 1;
//        int[] res = new int[bucketSizes.length];
//        for (int i = 0; i < bucketSizes.length; i++) {
//            res[i] = offset;
//            offset += bucketSizes[i];
//        }
//        return res;
//
//    }
//
//    static int[] findBucketTails(int[] bucketSizes) {
//        int offset = 1;
//        int[] res = new int[bucketSizes.length];
//        for (int i = 0; i < bucketSizes.length; i++) {
//            offset += bucketSizes[i];
//            res[i] = offset - 1;
//        }
//        return res;
//    }
//
//    static String[] makeSuffixArrayByInducedSorting(String s, int SIGMA) {
//        int[] type = buildType(s);
//
//        findBucketSizes(s.toCharArray(), SIGMA);
//    }
//
//    static int[] guessLMSSort(String s, int[] bucketSizes, int[] type) {
//        int[] guessedSuffixArray = new int[s.length() + 1];
//        Arrays.fill(guessedSuffixArray, -1);
//        int[] bucketTails = findBucketTails(bucketSizes);
//        for (int i = 0; i < s.length(); i++) {
//            if (!isLMSChar(i, type)) continue;
//            int bucketIndex = s.charAt(i);
//            guessedSuffixArray[bucketTails[bucketIndex]] = i;
//            bucketTails[bucketIndex] -= 1;
//
//        }
//        guessedSuffixArray[0] = s.length();
//        return guessedSuffixArray;
//    }
//
//    public static void main(String[] args) {
//        String s = "cabbage";
//        T1044 t = new T1044();
////        t.showTypeMap(s);
////        t.SA_IS(s, 256);\
//        char[] encode_cabbahe = {2, 0, 1, 1, 0, 6, 4};
//        int[] bucketSizes = findBucketSizes(encode_cabbahe, 7);
//        System.out.println(Arrays.toString(bucketSizes));
//    }
//
//}

public class T1044 {
    private int k, n;
    private int[] rank;
    public String longestDupSubstring(String S) {

        //sa
        n = S.length();

        Integer[] sa = new Integer[n + 1];
        rank = new int[n + 1];

        for(int i = 0; i <= n; i ++){
            sa[i] = i;
            rank[i] = i < n ? S.charAt(i) : -1;
        }

        k = 1;
        while(k < n){
            // sort过程利用到了rank[i + k]位置，相当于此时获得的sa数组就是严格按照S[i, 2k]递增的
            Arrays.sort(sa, (a, b) -> compareTo(a, b));

            // 使用已经排好序的sa对rank进行更新
            int[] temp = new int[n + 1];
            temp[sa[0]] = 0;
            for(int i = 1; i <= n; i ++)
                temp[sa[i]] = temp[sa[i - 1]] + (compareTo(sa[i - 1], sa[i]) < 0 ? 1 : 0);

            rank = temp;
            k *= 2;
        }

        //height
        int l = 0, maxP = -1;
        for(int i = 0; i <= n; i ++) rank[sa[i]] = i;
        int[] height = new int[n + 1];
        height[0] = 0; // 显示设置第一个height位置为0
        int h = 1;
        for(int i = 0; i < n; i ++){
            int j = sa[rank[i] - 1];
            if(h > 0) h --;

            while(i + h < n && j + h < n && S.charAt(i + h) == S.charAt(j + h))
                h ++;

            height[rank[i]] = h;
            if(h > l){
                l = h;
                maxP = i;
            }
        }

        if(l == 0) return "";
        return S.substring(maxP, maxP + l);
    }

    private int compareTo(int i, int j){
        if(rank[i] != rank[j]) return rank[i] - rank[j];
        return rank[Math.min(n, i + k)] - rank[Math.min(n, j + k)];
    }
}