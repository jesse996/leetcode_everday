import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列 {
    static public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int winSum = 0;
        int i = 1, j = 1;
        while ( i <= target / 2) {
            if (winSum<target){
                winSum+=j;
                j+=1;
            }else if (winSum>target){
                winSum-=i;
                i+=1;
            }else {
                int[] tmp=new int[j-i];
                for (int k=i;k<j;k++){
                    tmp[k-i]=k;
                }
                res.add(tmp);
                winSum-=i;
                i+=1;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.printf(""+ Arrays.deepToString(findContinuousSequence(15)));
    }
}
