import java.util.Arrays;
public class fifteen{
    //? Sudoku Solver
    public static void main(String[] args){
        char[][] arr = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','.','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
        };
        sudokuSolver(arr);
        // System.out.print(Arrays.deepToString(arr));
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isSafe(arr,num,i,j)){
                            arr[i][j] = num;
                            if(sudokuSolver(arr)){
                                return true;
                            }else{
                                arr[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafe(char[][] arr,char num,int row,int col){
        for(int i=0;i<9;i++){
            if(arr[i][col] == num) return false;
            if(arr[row][i] == num) return false;
            if(arr[3*(row/3)+i/3][3*(col/3)+i%3] == num) return false;
        }
        return true;
    }
}