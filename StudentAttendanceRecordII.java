package main.java.leetCode;

/**
 * Created by qiuqian on 8/17/18.
 */
public class StudentAttendanceRecordII {

    public int checkRecord(int n) {
        //numbers[i][j][k] denotes the number of all possible rewardable records with length i which contains j 'A's and ends with k 'L's
        int[][][] numbers = new int[n + 1][2][3];
        numbers[1] = new int[][]{{1, 1, 0}, {1, 0, 0}};
        int i = 2;
        while(i <= n) {
            numbers[i][0][0] = (numbers[i - 1][0][0] + numbers[i - 1][0][1] + numbers[i - 1][0][2]) % 1000000007;
            numbers[i][0][1] = numbers[i - 1][0][0];
            numbers[i][0][2] = numbers[i - 1][0][1];
            numbers[i][1][0] = (numbers[i - 1][0][0] + numbers[i - 1][0][1] + numbers[i - 1][0][2] + numbers[i - 1][1][0] + numbers[i - 1][1][1] + numbers[i - 1][1][2]) % 1000000007;
            numbers[i][1][1] = numbers[i - 1][1][0];
            numbers[i][1][2] = numbers[i - 1][1][1];
        }
        int result = (numbers[n][0][0] + numbers[n][0][1] + numbers[n][0][2] + numbers[n][1][0] + numbers[n][1][1] + numbers[n][1][2]) % 1000000007;
        return result;
    }

    //error point: if we don't return count, just add 1 to count,
    // the count number will not be updated

    public long helper(char[] option, int n, StringBuilder builder, long count) {
        if(!rewardable(builder.toString())) {
            return count;
        }
        if(n == 0) {
            count++;
            return count;
        }
        for(int i = 0; i < option.length; i++) {
            builder.append(option[i]);
            count = helper(option, n - 1, builder, count);
            //error point: the name of function: deleteCharAt()
            builder.deleteCharAt(builder.length() - 1);
        }
        return count;
    }


    public boolean rewardable(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        System.out.println(test.checkRecord(1));

    }
}
