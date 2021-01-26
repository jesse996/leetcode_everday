import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/25 4:42 下午
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T959 {
    public int regionsBySlashes(String[] grid) {
        char[][] arr = Arrays.stream(grid).map(String::toCharArray).toArray(char[][]::new);
        int m = arr.length;
        int n = arr[0].length;
        UF uf = new UF(m * n * 4);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (m * i + j) * 4;
                //单元内合并
                if (arr[i][j] == ' ') {
                    uf.union(index, index + 1);
                    uf.union(index, index + 2);
                    uf.union(index, index + 3);
                } else if (arr[i][j] == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (arr[i][j] == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                }
                //单元间合并，合并右边和下面
                if (j < n - 1) {
                    uf.union(index + 1, index + 7);
                }
                if (i < m - 1) {
                    uf.union(index + 2, index + 4 * n);
                }
            }
        }
        return uf.count;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean isConnected(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return true;
            return false;
        }

        public int find(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa;
                count--;
            }
        }

        public int count() {
            return count;
        }
    }
}
