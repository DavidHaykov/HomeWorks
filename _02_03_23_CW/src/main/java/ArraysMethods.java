public class ArraysMethods {
    public static int[][] addRow(int[][] matrix, int[] row, int index){
        if(row.length != matrix.length||index<0||index>matrix[0].length){
            return null;
        }
        int[][]res = new int[matrix.length][];  //2[] == matrix.length+1
        for(int i=0; i< res.length; i++){
            res[i] = add(matrix[i], index, row[i]);
        }
        return res;
    }
    public static int[] add(int[] array, int index, int number){
        int[] res = new int[array.length+1];
        System.arraycopy(array, 0, res, 0, index);
        res[index] = number;
        System.arraycopy(array, index, res, index+1, array.length-index);

        return res;
    }
    public static int[][] transp(int[][] matrix){
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
