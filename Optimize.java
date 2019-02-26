import java.util.ArrayList;
public class Optimize{
  private int[][] board;
  private int[][] game;
  private int[] moves;
  public Optimize(int r, int c){
    board=new int[r][c];
    game= new int[r][c];
    this.clear();
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        this.construct(i,j);
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
    for(int i=0;i<game.length;i++){
      for(int j=0;j<game[0].length;j++){
        game[i][j]=0;
      }
    }
  }
  public boolean addKnight(int r,int c,int num){
    if (r>=0&&r<game.length&&c>=0&&c<game[0].length&&game[r][c]==0){
      game[r][c]=num;
      return true;
    }
    return false;
  }
  public boolean removeKnight(int r,int c){
    if (r>=0&&r<game.length&&c>=0&&c<game[0].length){
      game[r][c]=0;
      return true;
    }
    return false;
  }

  public String toString(){
    String s="";
    for (int i=0;i<game.length;i++){
      s+="\n";
      for (int j=0;j<game[0].length;j++){
        if(game[i][j]==0){
          s+="_ ";
        }
        else if (game[i][j]<=9){
          s+=" "+game[i][j]+" ";
        }
        else{
          s+=game[i][j]+" ";
        }
      }
    }
    return s;
  }
  public boolean solve(int startingRow, int startingCol){
    for (int i=0;i<game.length;i++){
      for (int j=0;j<game[0].length;j++){
        if(game[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    if(startingRow<0&&startingCol<0){
      throw new IllegalArgumentException();
    }
  //  if (solveH(startingRow,startingCol,1)){
    //  return true;
    //}
    else{
      this.clear();
      return false;
    }
  }
  public ArrayList<Integer> findLeast(int r,int c){
    ArrayList<Integer> movenums=new ArrayList<Integer>();
    movenums.add(board[r+moves[0]][c+moves[1]]);
    ArrayList<Integer> ordermoves=new ArrayList<Integer>();
    ordermoves.add(0);
    for(int i=1;i<8;i++){
      for (int k=0;k<movenums.size();k++) {
        if(r+moves[2*i]>=0&&c+moves[2*i+1]>=0&&r+moves[2*i]<board.length&&c+moves[2*i+1]<board[0].length){
          if(board[r+moves[2*i]][c+moves[2*i+1]]<=movenums.get(k)){
            movenums.add(k,board[r+moves[2*i]][c+moves[2*i+1]]);
            ordermoves.add(k,i);
            k=10;
          }
          else{
            if(i==7){
              movenums.add(board[r+moves[2*i]][c+moves[2*i+1]]);
              ordermoves.add(i);
            }
          }
        }
        else{
          k=10;
        }
      }
    }
    return ordermoves;
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
    Optimize a= new Optimize(5,5);
    System.out.println(a.ChanceString());
  }
}
