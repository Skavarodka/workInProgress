import java.util.Arrays;

public class aads {
    public static void main(String[] args) {
        int [][] twoDimArr = new int[5][];
        for (int i = 0; i < twoDimArr.length; i++) {
            twoDimArr[i] = getArr(7, i*7 + 11, (i % 2 == 0));
            System.out.println(Arrays.toString(twoDimArr[i]));
        }
    }

    private static int[] getArr(int lengthArr, int begin, boolean direction) {
        int[] ret = new int[lengthArr];
        int a;
        a = (direction) ? 0 : ret.length - 1;
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[Math.abs(a - i)] = begin++;
        }
        return ret;
    }
}