package maze;

import java.util.ArrayList;

public class CountMazeWays {
    public static void main(String[] args) {
        System.out.println(mazeCount(3,3));
        System.out.println(mazePath(3,3,"",new ArrayList<String>()).toString());
        System.out.println(mazePathWithDiagonal(3,3,"",new ArrayList<String>()).toString());

        boolean[][] board= new boolean[][]{{true,true,true},
            {true,true,true},
            {true,true,true}
        };
        System.out.println(mazePathWithUpAndLeft(3,3,"",new ArrayList<String>(),board));
    }

    public static int mazeCount(int row,int column){
        if(row==1 || column==1){
            return 1;
        }
        return mazeCount(row-1,column)+mazeCount(row,column-1);
    }

    public static ArrayList<String> mazePath(int row, int column,String path, ArrayList<String> paths){
        if(row==1 && column==1){
             paths.add(path);
             return paths;
        }
        if(row!=1)
            mazePath(row-1,column,path+"D",paths);
        if(column!=1)
            mazePath(row,column-1,path+"R",paths);
        return paths;
    }


    public static ArrayList<String> mazePathWithDiagonal(int row, int column,String path, ArrayList<String> paths){
        if(row==1 && column==1){
            paths.add(path);
            return paths;
        }
        if(column>1 && row>1)
            mazePathWithDiagonal(row-1,column-1,path+"D",paths);
        if(row>1)
            mazePathWithDiagonal(row-1,column,path+"V",paths);
        if(column>1)
            mazePathWithDiagonal(row,column-1,path+"R",paths);

        return paths;
    }

    public static ArrayList<String> mazePathWithUpAndLeft(int row, int column,String path, ArrayList<String> paths,boolean[][] board){
        if(row==1 && column==1){
            paths.add(path);
            return paths;
        }
        if(!board[row-1][column-1])
            return paths;

        //Dont visit again the paths which is already visited in this recursion tree.
        board[row-1][column-1] = false;

        if(row>1 )
            mazePathWithUpAndLeft( row - 1, column, path + "D", paths,board);

        if(column>1 )
            mazePathWithUpAndLeft(row,column-1,path+"R",paths,board);

        if(row<board.length-1 )
            mazePathWithUpAndLeft(row + 1, column, path + "U", paths,board);

        if(column<board.length-1 )
            mazePathWithUpAndLeft(row , column+1, path + "L", paths,board);

        //Mark what ever you marked false in this recursion tree - Backtracking...
        board[row-1][column-1] = true;

        return paths;
    }






}
