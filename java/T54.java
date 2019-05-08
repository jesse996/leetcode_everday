import java.util.ArrayList;
import java.util.List;

// 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

// 示例 1:

// 输入:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// 输出: [1,2,3,6,9,8,7,4,5]
// 示例 2:

// 输入:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
public class T54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m=matrix.length;
    int n=matrix[0].length;
    List<Integer> list =new ArrayList<>();
    int i=0,j=0,di=0,dj=1;
    for(int c=0;c<m*n;c++){
      list.add(matrix[i][j]);
      matrix[i][j]=0;//置0或者别的值
      if(matrix[(i+di+m)%m][(j+dj+n)%n]==0){
        int tmp=di;
        di=dj;
        dj=-tmp;
      }
      i+=di;
      j+=dj;
    }
    return list;
    
  }
  public static void main(String[] args) {
    System.out.println(new T54().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
  }
}