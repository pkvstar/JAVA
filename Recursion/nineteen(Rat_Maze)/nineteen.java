import java.util.ArrayList;
import java.util.Collections;
public class nineteen{
    //? Rat in a Maze
    public static void main(String args[]){
        int[][] maze = {
            {1, 1, 1, 1},
            {0, 0, 1, 0},
            {1, 1, 1, 1},
            {0, 0, 0, 1}
        };
        ArrayList<String> li = new ArrayList<>();
        ratMaze(0,0,maze,"",li);
        Collections.sort(li); //* to be in lexicographical order(if question want in lexicographical order
        System.out.print(li);
    }
    public static void ratMaze(int row,int col,int[][] maze,String str,ArrayList<String> li){
        if(row==maze.length-1 && col==maze[0].length-1){
            li.add(str);
            return;
        }
        if(row<0 || col<0 || col>=maze[0].length || row>=maze.length || maze[row][col]==0){
            return;
        }
        maze[row][col] = 0; //marked pass
        ratMaze(row-1,col,maze,str+"U",li); //top
        ratMaze(row,col+1,maze,str+"R",li); //right
        ratMaze(row+1,col,maze,str+"D",li); //down
        ratMaze(row,col-1,maze,str+"L",li); //left
        maze[row][col] = 1; //backtrack
    }
}