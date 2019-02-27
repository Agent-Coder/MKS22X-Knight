import java.util.ArrayList;
public class KnightBoard{
  private int[][] board;
  private int[][] game;
  private int[] moves;
 public KnightBoard(int sizer,int sizec){
   if (sizer<=0||sizec<=0){
     throw new IllegalArgumentException();
   }
   board=new int[sizer][sizec];
   game= new int[sizer][sizec];
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
 //blank boards display 0's as underscores
 //you get a blank board if you never called solve or when there is no solution
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


 //@throws IllegalStateException when the board contains non-zero values.
 //@throws IllegalArgumentException when either parameter is negative or out of bounds.
/* public boolean solve(int startingRow, int startingCol){
   for (int i=0;i<game.length;i++){
     for (int j=0;j<game[0].length;j++){
       if(game[i][j]!=0){
         throw new IllegalStateException();
       }
     }
   }
   if(startingRow<0||startingCol<0||startingRow>=game.length||startingCol>=game[0].length){
     throw new IllegalArgumentException();
   }
   if (solveH(startingRow,startingCol,1)){
     return true;
   }
   else{
     for (int i=0;i<game.length;i++){
       for (int j=0;j<game[0].length;j++){
         game[i][j]=0;
       }
     }
     return false;
   }
 }
 //Suggestion:
 private boolean solveH(int row ,int col, int level){
   if(level>=game.length*game[0].length+1){
     return true;
   }
   if(addKnight(row,col,level)){
     for (int i=0;i<8;i++){
       if(solveH(row+moves[2*i],col+moves[2*i+1],level+1)){
         return true;
       }
     }
     removeKnight(row,col);
   }
     return false;
 }*/
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

 //@throws IllegalStateException when the game contains non-zero values.
 //@throws IllegalArgumentException when either parameter is negative or out of bounds.
 public int countSolutions(int startingRow, int startingCol){
   for (int i=0;i<game.length;i++){
     for (int j=0;j<game[0].length;j++){
       if(game[i][j]!=0){
         throw new IllegalStateException();
       }
     }
   }
   if(startingRow<0||startingCol<0||startingRow>=game.length||startingCol>=game[0].length){
     throw new IllegalArgumentException();
   }
   int x=Solutions(startingRow,startingCol,1,0)/8;
   for (int i=0;i<game.length;i++){
     for (int j=0;j<game[0].length;j++){
       game[i][j]=0;
     }
   }
   return x;
 }

 public int Solutions(int row, int col, int level,int count){
   //System.out.println(this);
   //System.out.println("count "+count+ " level "+level );

   if(level==game.length*game[0].length+1){
     return 1;
   }
   if(addKnight(row,col,level)){
     for (int i=0;i<8;i++){
       int x=Solutions(row+moves[2*i],col+moves[2*i+1],level+1,0);
       if(x!=0){
         count+=x;
       }
     }
   removeKnight(row,col);
   }
   return count;
 }
 public boolean solve(int startingRow, int startingCol){
   for (int i=0;i<game.length;i++){
     for (int j=0;j<game[0].length;j++){
       if(game[i][j]!=0){
         throw new IllegalStateException();
       }
     }
   }
   if(startingRow<0||startingCol<0||startingRow>=game.length||startingCol>=game[0].length){
     throw new IllegalArgumentException();
   }
   if (solveH(startingRow,startingCol,1)){
     return true;
   }
   else{
     this.clear();
     return false;
   }
 }

 public boolean solveH(int row,int col,int level){
   if(level>=game.length*game[0].length+1){
     return true;
   }
   if(addK(row,col,level)){
     //System.out.println(this);
     //System.out.println(this.ChanceString());
     ArrayList<Integer> order=this.findLeast(row,col);
     //System.out.println("");
     /*for (int a=0;a<order.size();a++ ) {
       System.out.print(order.get(a)+",");
     }*/
     for (int i=0;i<order.size();i++){
       if(solveH(row+moves[2*order.get(i)],col+moves[2*order.get(i)+1],level+1)){
         return true;
       }
     }
     if(solveH(board.length,board[0].length,level+1)){
       return true;
     }
     removeK(row,col);
   }
     return false;
 }

 public ArrayList<Integer> findLeast(int r,int c){
   ArrayList<Integer> movenums=new ArrayList<Integer>();
   ArrayList<Integer> ordermoves=new ArrayList<Integer>();
   for(int i=0;i<8;i++){
     if(r+moves[2*i]>=0&&c+moves[2*i+1]>=0&&r+moves[2*i]<board.length&&c+moves[2*i+1]<board[0].length){
       if(movenums.size()==0){
         movenums.add(board[r+moves[2*i]][c+moves[2*i+1]]);
         ordermoves.add(i);
       }
       else{
         for (int k=0;k<movenums.size();k++) {
           if(board[r+moves[2*i]][c+moves[2*i+1]]<=movenums.get(k)){
             movenums.add(k,board[r+moves[2*i]][c+moves[2*i+1]]);
             ordermoves.add(k,i);
             k=movenums.size();
           }
           else{
             if(k==movenums.size()-1){
               movenums.add(board[r+moves[2*i]][c+moves[2*i+1]]);
               ordermoves.add(i);
             }
           }
         }
       }
     }
   }
     return ordermoves;
 }
 public boolean addK(int r,int c,int num){
   if (r>=0&&r<game.length&&c>=0&&c<game[0].length&&game[r][c]==0){
     game[r][c]=num;
     for (int i=0;i<8 ;i++ ) {
       if(r+moves[2*i]>=0&&c+moves[2*i+1]>=0&&r+moves[2*i]<board.length&&c+moves[2*i+1]<board[0].length){
         board[r+moves[2*i]][c+moves[2*i+1]]=board[r+moves[2*i]][c+moves[2*i+1]]-1;
       }
     }
     return true;
   }
   return false;
 }
 public boolean removeK(int r,int c){
   if (r>=0&&r<game.length&&c>=0&&c<game[0].length){
     game[r][c]=0;
     for (int i=0;i<8 ;i++ ) {
       if(r+moves[2*i]>=0&&c+moves[2*i+1]>=0&&r+moves[2*i]<board.length&&c+moves[2*i+1]<board[0].length){
         board[r+moves[2*i]][c+moves[2*i+1]]=board[r+moves[2*i]][c+moves[2*i+1]]+1;
       }
     }
     return true;
   }
   return false;
 }
  //level is the # of the knight
  //public static void main(String[] args) {
    //KnightBoard k=new KnightBoard(5,6);

    //System.out.println(k.solve(0,0));
    //System.out.println(k);
    //KnightBoard n=new KnightBoard(2,2);

    //System.out.println(n.countSolutions(0,3));
    //KnightBoard i=new KnightBoard(3,3);

    //System.out.println(i.countSolutions(-1,0));
    //KnightBoard g=new KnightBoard(3,3);

    //System.out.println(g.countSolutions(0,-3));
  //}
}
