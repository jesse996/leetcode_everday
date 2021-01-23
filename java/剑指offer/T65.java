package 剑指offer;

/**
 * @Author: jesse
 * @Date: 2021/1/23 5:43 下午
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class T65 {
    public int add(int a, int b) {
        while(b!=0){
            int tmp=a^b;
            b=((int)(a&b)<<1);
            a=tmp;
        }
        return a;
    }
}
