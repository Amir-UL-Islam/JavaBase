package com.aiokleo.JavaComparator;
import java.io.*;
import java.util.*;
import java.lang.*;

//Shortest Approach
class Player{
    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b){
        if(a.score == b.score){
            return a.name.compareToIgnoreCase(b.name);
        }else if(a.score > b.score) {
            return -1;
        } else if(a.score < b.score) {
            return 1;
        }
        return 1;
    }
}
public class Solution {
    private static final Checker checker = new Checker();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nPlayer = Integer.parseInt(in.nextLine());

        Player[] players = new Player[nPlayer];
        for (int player = 0; player < nPlayer; player++){
            players[player] = new Player(in.next(), in.nextInt());
        }

//        System.out.println(players);

        Arrays.sort(players, checker);
        for(int i = 0; i < players.length; i++) {
            System.out.println(players[i].name + " " + players[i].score);
        }
    }

}
