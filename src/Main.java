public class Main {
    public static void main(String[] args) {
        int max = 120;
        int[][] array = new int[max / 10][10];
        boolean dir = true;

        for (int i = 0; i < array.length; i++) {
            if  (dir){
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = max--;
                }
                dir = false;
            }
            else {
                for (int j = array[i].length - 1; j >= 0; j--) {
                    array[i][j] = max--;
                }
                dir = true;
            }
        }

        // Output
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }
    }
}