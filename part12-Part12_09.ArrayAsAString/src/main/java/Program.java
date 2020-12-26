
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int[][] matrix = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                sb.append(matrix[row][column]);
                if(column==matrix[row].length-1){
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
