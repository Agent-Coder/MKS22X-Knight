
public class KnightBoard{
  private int[][] sequence;
  public KnightBoard(int size){
    for (int i=0;i<sequence.length;i++){
      for (int j=0;j<sequence.length;j++){
        sequence[i][j]=0;
      }
    }
  }
  //blank boards display 0's as underscores
  //you get a blank board if you never called solve or when there is no solution
  public String toString(){
  }


  //@throws IllegalStateException when the board contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  public boolean solve(int startingRow, int startingCol){
    return solveKnight();
  }

  //@throws IllegalStateException when the board contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  public int countSolutions(int startingRow, int startingCol)

  //Suggestion:
  private boolean solveH(int row ,int col, int level)
  //level is the # of the knight
}
