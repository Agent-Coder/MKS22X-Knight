
public class KnightBoard{
  private int[][] sequence;
  public KnightBoard(int sizer,int sizec){
    sequence=new int[sizer][sizec];
    for (int i=0;i<sequence.length;i++){
      for (int j=0;j<sequence[0].length;j++){
        sequence[i][j]=0;
      }
    }
  }
  //blank boards display 0's as underscores
  //you get a blank board if you never called solve or when there is no solution
  public String toString(){
    String s="";
    for (int i=0;i<sequence.length;i++){
      s+="\n"
      for (int j=0;j<sequence[0].length;j++){
        if (sequence[i][j]>9){
          s+="_"+sequence[i][j]+" ";
        }
        else{
          s+=sequence[i][j]+" ";
        }
      }
    }
    return s;
  }


  //@throws IllegalStateException when the board contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  public boolean solve(int startingRow, int startingCol){
    return solveKnight(startingRow,startingCol);
  }
  public boolean SolveKnight(int r,int c,){

  }
  public boolean addKnight(int r,int c,int amount){
    boolean place=false;
    if(amount==0){
    if (r+2<board.length){


      }
    }
  }

  //@throws IllegalStateException when the board contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  public int countSolutions(int startingRow, int startingCol)

  //Suggestion:
  private boolean solveH(int row ,int col, int level)
  //level is the # of the knight
}
