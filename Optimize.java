public class Optimize{
  public Optimize(){
    this.clear;
    board[0][0]=1;
    board[r-1][0]=1;
    board[0][c-1]=1;
    board[r-1][c-1]=1;
    if (r>3&&c>3){
      board[0][0]=2;
      board[r-1][0]=2;
      board[0][c-1]=2;
      board[r-1][c-1]=2;
      for(int a=1;a<board[0].length;a++){
        if(a==1||a==board[0].length-2){
          board[0][a]=3;
          board[a][0]=3;
          board[0][board[0].length-2]=3;
          board[a][board[1].length-1]=3;
          board[board.length-2][board[0].length]=3;
          board[board.length-1][board[0].length-2]=3;
          board[board.length-2][0]=3
          board[board.length-1][1]=3;
        }
        else{
          board[board.length-1][a]=4;
        }
      }
  }
  public clear(){
    for(int i=0;i<board.length;i++){
      for(int j=0;i<board[0].length;i++){
        board[i][j]=0
      }
    }
  }
}
