// 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

// 示例 1:

// 输入: num1 = "2", num2 = "3"
// 输出: "6"
// 示例 2:

// 输入: num1 = "123", num2 = "456"
// 输出: "56088"
// 说明：

// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

//字符串相乘

class Solution {
    public String multiply(String num1, String num2) {

        // num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
        // 例: 123 * 45, 123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
        // index: 0 1 2 3 4

        // 1 2 3
        // * 4 5
        // ---------
        // 1 5
        // 1 0
        // 0 5
        // ---------
        // 0 6 1 5
        // 1 2
        // 0 8
        // 0 4
        // ---------
        // 0 5 5 3 5
        // 这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中

        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 <= 0 || n2 <= 0)
            return "";
        int[] mul = new int[n1 + n2];

        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitmul += mul[i + j + 1]; // 先加低位判断是否有新的进位

                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while (i < mul.length - 1 && mul[i] == 0)
            i++;
        for (; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}