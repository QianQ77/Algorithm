package main.java.leetCode;

/**
 * Created by qiuqian on 8/18/17.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {

        int c = nums[0];
        for(int i = 1; i < nums.length; i++){
            c = c ^ nums[i];
        }

        String cBit = Integer.toBinaryString(c);
        int pos = 0;
        for(int i = cBit.length() - 1; i >=0; i--){
            if(cBit.charAt(i) == '1'){
                break;
            }else{
                pos++;
            }
        }
        int result1 = 0;
        int result2 = 0;

        for(int i = 0; i < nums.length; i++){
            String bits = Integer.toBinaryString(nums[i]);
            int index = bits.length() - 1 - pos;
            if(index >= 0 ){
                if(bits.charAt(index) == '0'){
                    result1 ^= nums[i];
                }else{
                    result2 ^= nums[i];
                }
            }

        }
        return new int[]{result1, result2};
    }

    public int[] singleNumber2(int[] nums) {
        int c = nums[0];
        for(int i = 1; i < nums.length; i++){
            c = c ^ nums[i];
        }

        //after calculation, the bits of c only contains one '1', others are '0's; the '1' is the first 1 from right in original bits of c
        c = c - ( c & (c - 1));

        int result1 = 0;
        int result2 = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = c & nums[i];
            if(temp == c){
                result1 ^= nums[i];
            }
            else{
                result2 ^= nums[i];
            }
        }
        return new int[]{result1, result2};
    }

    public static void main(String[] args) {
        SingleNumberIII single = new SingleNumberIII();

        int[] array = new int[]{0,0,1,2};
        int[] result = single.singleNumber(array);
        int[] result2 = single.singleNumber2(array);
        System.out.println(result[0] + "," + result[1]);
        System.out.println(result2[0] + "," + result2[1]);
    }
}
