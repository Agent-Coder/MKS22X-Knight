public class Optimize{
  private int[][] board;
  public Optimize(int r, int c){
    board=new int[r][c];
    for(int i=0;i<board.length;i++){
      for(int j=0;i<board[0].length;i++){
        board[i][j]=0;
      }
    }
    board[0][0]=1;
    board[r-1][0]=1;
    board[0][c-1]=1;
    board[r-1][c-1]=1;
    if (r>3&&c>3){
      board[0][0]=2;
      board[r-1][0]=2;
      board[0][c-1]=2;
      board[r-1][c-1]=2;
      for(int a=1;a<board[0].length-1;a++){
        if(a==1||a==board[0].length-2){
          board[0][a]=3;
          board[a][0]=3;
          board[0][board[0].length-2]=3;
          board[a][board[1].length-1]=3;
          board[board.length-2][board[0].length-1]=3;
          board[board.length-1][board[0].length-2]=3;
          board[board.length-2][0]=3;
          board[board.length-1][1]=3;
        }
        else{
          board[0][a]=4;
          board[board.length-1][a]=4;
          board[a][0]=4;
          board[a][board[0].length-1]=4;
        }
      }
    }
  }
  public void clear(){
    for(int i=0;i<board.length;i++){
      for(int j=0;i<board[0].length;i++){
        board[i][j]=0;
      }
    }
  }
  public String toString(){
    String s="";
    for (int i=0;i<board.length;i++){
      s+="\n";
      for (int j=0;j<board[0].length;j++){
        if(board[i][j]==0){
          s+="_ ";
        }
        else if (board[i][j]<=9){
          s+=" "+board[i][j]+" ";
        }
        else{
          s+=board[i][j]+" ";
        }
      }
    }
    return s;
  }
  public String ChanceString(){
    String s="";
    for (int i=0;i<board.length;i++){
      s+="\n";
      for (int j=0;j<board[0].length;j++){
          s+=" "+board[i][j]+" ";
      }
    }
    return s;
  }
  public static void main(String[] args) {
    Optimize a= new Optimize(9,9);
    System.out.println(a.ChanceString());
  }
}
