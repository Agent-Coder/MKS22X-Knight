public class Optimize{
  private int[][] board;
  public Optimize(int r, int c){
    board=new int[r][c];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        this.construct(i,j);
      }
    }
  }
  public void construct(int r,int c){
    if(r+2<board.length){
      if(c+1<board[0].length){
        board[r][c]=board[r][c]+1;
      }
      if(c-1>=0){
        board[r][c]=board[r][c]+1;
      }
    }
    if(r-2>=0){
      if(c+1<board[0].length){
        board[r][c]=board[r][c]+1;
      }
      if(c-1>=0){
        board[r][c]=board[r][c]+1;
      }
    }
    if(c+2<board[0].length){
      if(r+1<board.length){
        board[r][c]=board[r][c]+1;
      }
      if(r-1>=0){
        board[r][c]=board[r][c]+1;
      }
    }
    if(c-2>=0){
      if(r+1<board.length){
        board[r][c]=board[r][c]+1;
      }
      if(r-1>=0){
        board[r][c]=board[r][c]+1;
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
