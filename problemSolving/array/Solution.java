public class Solution {
//    public static boolean canWin(int leap, int[] game) {
//        // Return true if you can win the game; otherwise, return false.
//        return canWin(leap, game,0);
//    }
//    public static boolean canWin(int leap,int[] game,int pos){
//
//        if (pos<0) {
//            return false;
//        }
//        if (game[pos] ==1) {
//            return false;
//        }
//        if (pos+1>=game.length) {
//            return true;
//        }
//        if (pos+leap>=game.length) {
//            return true;
//        }
//        game[pos]=1; // To block moving forward -backward
//        return   canWin(leap,game,pos+leap) || canWin(leap,game,pos+1) || canWin(leap,game,pos-1) ;
//    }


}
