
public class KnightBoard{
  private int[][] sequence;
  private int[] moves;
  public KnightBoard(int sizer,int sizec){
    sequence=new int[sizer][sizec];
    for (int i=0;i<sequence.length;i++){
      for (int j=0;j<sequence[0].length;j++){
        sequence[i][j]=0;
      }
    }
    moves=new int[16];
    moves[0]=2;
    moves[1]=1;
    moves[2]=2;
    moves[3]=-1;
    moves[4]=-2;
    moves[5]=1;
    moves[6]=-2;
    moves[7]=-1;
    moves[8]=1;
    moves[9]=2;
    moves[10]=1;
    moves[11]=-2;
    moves[12]=-1;
    moves[13]=2;
    moves[14]=-1;
    moves[15]=-2;
  }
  //blank boards display 0's as underscores
  //you get a blank board if you never called solve or when there is no solution
  public String toString(){
    String s="";
    for (int i=0;i<sequence.length;i++){
      s+="\n";
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
    return solveH(startingRow,startingCol,0);
  }

  public boolean addKnight(int r,int c,int num){
    if (r>=0&&r<sequence.length&&c>=0&&c<sequence.length&&sequence[r][c]==0){
      sequence[r][c]=num;
      return true;
    }
    return false;
  }
  public boolean removeKnight(int r,int c){
    if (r>=0&&r<sequence.length&&c>=0&&c<sequence.length){
      sequence[r][c]=0;
      return true;
    }
    return false;
  }

  //@throws IllegalStateException when the sequence contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  //public int countSolutions(int startingRow, int startingCol)

  //Suggestion:
  private boolean solveH(int row ,int col, int level){
    if(level==sequence.length*sequence[0].length+1){
      return true;
    }
    if(addKnight(row,col,level)){
        for (int i=0;i<8;i++)
      }
      return false;


            //solveH(row+2 ,col-1,level+1)||
            //solveH(row-2 ,col+1,level+1)||
            //solveH(row-2 ,col-1,level+1)||
            //solveH(row+1 ,col+2,level+1)||
            //solveH(row+1 ,col-2,level+1)||
            //solveH(row-1 ,col+2,level+1)||
            //solveH(row-1 ,col-2,level+1);
    }
    removeKnight(row,col);
    return false;
  }
  //level is the # of the knight
  public static void main(String[] args) {
    KnightBoard k=new KnightBoard(3,3);
    System.out.println(k.solve(0,0));
  }
}
