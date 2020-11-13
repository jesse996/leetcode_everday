package 剑指offer;

/**
 * Created by jesse on 2020/11/13 下午3:55
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * db[i]表示前i个数字可能的翻译
 * db[i+1]=  db[i-1]+2    if arr[i]=1||(arr[i]==2 && arr[i+1]<=5)
 * or db[i-1]
 */
public class T46 {
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        String str = String.valueOf(num);
        int[] db = new int[str.length() + 1];
        db[0] = db[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                db[i] = db[i - 2] + db[i - 1];
            } else {
                db[i] = db[i - 1];
            }
        }
        return db[db.length - 1];
    }

}
