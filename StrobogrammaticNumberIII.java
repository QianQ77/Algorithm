package main.java.leetCode;

/**
 * Created by qiuqian on 10/23/18.
 */
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int M = low.length();
        int N = high.length();
        if(M > N) {
            return 0;
        }
        int result = 0;

        for(int size = M + 1; size < N; size++) {
            result += count(size);
        }
        result += helper(low, high);
        return result;

    }

    private int count(int size) {
        if(size == 0) return 0;
        if(size == 1) return 3;
        int result = 4;
        for(int i = 1; i < size / 2; i++) {
            result *= 5;
        }
        if(size % 2 == 1) result *= 3;
        return result;
    }

    private int helper(String low, String high) {
        char[] nums1 = new char[] {'0', '1', '8', '6', '9'};
        char[] nums2 = new char[] {'0', '1', '8', '9', '6'};
        int result =  dfs(new char[low.length()], nums1, nums2, low, high, 0);
        if(high.length() > low.length()) {
            result += dfs(new char[high.length()], nums1, nums2, low, high, 0);
        }
        return result;
    }

    private int dfs(char[] chars, char[] nums1, char[] nums2, String low, String high, int start) {
        int N = chars.length;
        int end = N - 1 - start;
        int result = 0;
        if(start > end) {
            String str = new String(chars);
            if(compare(str, low) >= 0 && compare(str, high) <= 0) {
                return 1;
            }else {
                return 0;
            }
        }
        int numstart = start == 0 && N > 0 ? 1 : 0;
        int numend = start == end ? 2 : 4;
        for(int i = numstart; i <= numend; i++) {
            chars[start] = nums1[i];
            chars[end] = nums2[i];
            result += dfs(chars, nums1, nums2, low, high, start + 1);
        }
        return result;
    }

    private int compare(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return str1.length() - str2.length();
        }
        return str1.compareTo(str2);
    }
    public static void main(String[] args) {
        StrobogrammaticNumberIII test = new StrobogrammaticNumberIII();
        /*
        System.out.println(test.count(2));
        System.out.println(test.count(1));
        System.out.println(test.count(3));
        System.out.println(test.count(4));
        System.out.println(test.count(5));

        System.out.println(test.compare("88", "55"));
        System.out.println(test.compare("88", "100"));
        */
        System.out.println(test.strobogrammaticInRange("50", "100"));
    }
}
