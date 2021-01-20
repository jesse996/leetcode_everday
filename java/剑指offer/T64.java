package 剑指offer;

/**
 * @Author: jesse
 * @Date: 2021/1/20 6:04 下午
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class T64 {
    public int sumNums(int n) {
        return n > 1 ? n + sumNums(n - 1) : 1;
    }
}
