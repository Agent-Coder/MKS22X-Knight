
public class KnightBoard{
  private int[][] sequence;
  private int[] moves;
  public KnightBoard(int sizer,int sizec){
    if (sizer<=0||sizec<=0){
      throw new IllegalArgumentException();
    }
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
        /*if(sequence[i][j]==0){
          s+="_ ";
        }
        else*/ if (sequence[i][j]<=9){
          s+=" "+sequence[i][j]+" ";
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
    for (int i=0;i<sequence.length;i++){
      for (int j=0;j<sequence[0].length;j++){
        if(sequence[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    if(startingRow<0&&startingCol<0){
      throw new IllegalArgumentException();
    }
    if (solveH(startingRow,startingCol,1)){
      return true;
    }
    else{
      for (int i=0;i<sequence.length;i++){
        for (int j=0;j<sequence[0].length;j++){
          sequence[i][j]=0;
        }
      }
      return false;
    }
  }

  public boolean addKnight(int r,int c,int num){
    if (r>=0&&r<sequence.length&&c>=0&&c<sequence[0].length&&sequence[r][c]==0){
      sequence[r][c]=num;
      return true;
    }
    return false;
  }
  public boolean removeKnight(int r,int c){
    if (r>=0&&r<sequence.length&&c>=0&&c<sequence[0].length){
      sequence[r][c]=0;
      return true;
    }
    return false;
  }

  //@throws IllegalStateException when the sequence contains non-zero values.
  //@throws IllegalArgumentException when either parameter is negative or out of bounds.
  public int countSolutions(int startingRow, int startingCol){
    return Solutions(startingRow,startingCol,1,0);
  }

  public int Solutions(int row, int col, int level,int count){
    //System.out.println("A");
    if(level>=sequence.length*sequence[0].length+1){
      //System.out.println("B");
      //System.out.println(count);
      return count+1;
    }
    //System.out.println("d");
    if(addKnight(row,col,level)){
    //System.out.println(this);
      for (int i=0;i<8;i++){
        if(Solutions(row+moves[2*i],col+moves[2*i+1],level+1,0)!=0){
          count++;
          removeKnight(row+moves[2*i],col+moves[2*i+1]);
        }
      }
    removeKnight(row,col);
    //System.out.println("f");
    }
    //System.out.println("g");
    return count;
  }
  //Suggestion:
  private boolean solveH(int row ,int col, int level){
    if(level>=sequence.length*sequence[0].length+1){
      return true;
    }
    if(addKnight(row,col,level)){
      for (int i=0;i<8;i++){
        if(solveH(row+moves[2*i],col+moves[2*i+1],level+1)){
          return true;
        }
      }
      removeKnight(row,col);
      return false;
    }
    else{
      return false;
    }
  }
  //level is the # of the knight
  public static void main(String[] args) {
    KnightBoard k=new KnightBoard(3,10);
    //System.out.println(k.solve(0,0));
    System.out.println(k.countSolutions(0,0));
    System.out.println(k);
  }
}
