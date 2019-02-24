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
       if(sequence[i][j]==0){
         s+="_ ";
       }
       else if (sequence[i][j]<=9){
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
   if(startingRow<0||startingCol<0||startingRow>=sequence.length||startingCol>=sequence[0].length){
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
   for (int i=0;i<sequence.length;i++){
     for (int j=0;j<sequence[0].length;j++){
       if(sequence[i][j]!=0){
         throw new IllegalStateException();
       }
     }
   }
   if(startingRow<0||startingCol<0||startingRow>=sequence.length||startingCol>=sequence[0].length){
     throw new IllegalArgumentException();
   }
   int x=Solutions(startingRow,startingCol,1,0)/8;
   for (int i=0;i<sequence.length;i++){
     for (int j=0;j<sequence[0].length;j++){
       sequence[i][j]=0;
     }
   }
   return x;
 }

 public int Solutions(int row, int col, int level,int count){
   //System.out.println(this);
   //System.out.println("count "+count+ " level "+level );

   if(level==sequence.length*sequence[0].length+1){
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
   }
     return false;
 }
  //level is the # of the knight
  //public static void main(String[] args) {
    //KnightBoard k=new KnightBoard(1,1);

    //System.out.println(k.countSolutions(1,0));
    //KnightBoard n=new KnightBoard(2,2);

    //System.out.println(n.countSolutions(0,3));
    //KnightBoard i=new KnightBoard(3,3);

    //System.out.println(i.countSolutions(-1,0));
    //KnightBoard g=new KnightBoard(3,3);

    //System.out.println(g.countSolutions(0,-3));
  //}
}
