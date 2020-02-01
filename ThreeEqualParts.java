package main.java.leetCode;

/**
 * Created by qiuqian on 10/20/18.
 */
public class ThreeEqualParts {
    public static int[] threeEqualParts(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while(i < j - 1) {
            int compij = compare(A, 0, i, j, A.length - 1);
            if(compij < 0) {
                i++;
            }else if(compij > 0) {
                j--;
            }else {
                if(compare(A, 0, i, i + 1, j - 1) == 0) {
                    return new int[]{i, j};
                }else {
                    j--;
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int compare(int[] A, int s1, int t1, int s2, int t2) {
        while(s1 <= t1 && s2 <= t2) {
            while(s1 <= t1 && A[s1] == 0) s1++;
            while(s2 <= t2 && A[s2] == 0) s2++;
            if(t1 - s1 > t2 - s2) {
                return 1;
            }else if (t1 - s1 < t2 - s2) {
                return -1;
            }else {
                s1++;
                s2++;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 0, 1, 0, 1};
        //System.out.println(compare(A, 1, 2, 3, 4));
        System.out.println(threeEqualParts(A)[0]);
    }


}
