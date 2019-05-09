// 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

// 示例:

// 输入: 3
// 输出:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class T59 {
  static public int[][] generateMatrix(int n) {
      int i=0,j=0,di=0,dj=1;
      int [][]res=new int[n][n];
      for(int count=1;count<=n*n;count++){
        res[i][j]=count;
        if(res[(i+di+n)%n][(j+dj+n)%n]!=0){
          int tmp=di;
          di=dj;
          dj=-tmp;
        }
        i+=di;
        j+=dj;
      }
      return res;
  }
  public static void main(String[] args) {
    int [][]a=generateMatrix(3);
    for (int[]  i : a) {
      for (int j : i) {
        System.out.println(j);
      }
    }
  }
}