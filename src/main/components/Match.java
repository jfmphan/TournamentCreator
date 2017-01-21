package main.components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Match {
    private int round;
    private Team team1;
    private Team team2;
    private Team winner;
    private int[] score = new int[3];
    private int matchNumber;

    public Match(int round, Team team1, Team team2, int matchNumber){
        this.round = round;
        this.team1 = team1;
        this.team2 = team2;
        this.matchNumber = matchNumber;
        score[0] = 0;
        score[1] = 0;
        score[2] = 0;
    }

    public Match(Team team1, Team team2, int matchNumber){
        this.round = round;
        this.team1 = team1;
        this.team2 = team2;
        this.matchNumber = matchNumber;
        score[0] = 0;
        score[1] = 0;
        score[2] = 0;
    }


    public void setScore(int match1, int match2, int match3){
        score[0] = match1;
        score[1] = match2;
        score[2] = match3;
    }

    public void setScore(int match1, int match2){
        score[0] = match1;
        score[1] = match2;
    }

    public void setWinner(Team winner){this.winner = winner;}

    public int getRound(){return this.round;}
    public Team getTeam1(){return this.team1;}
    public Team getTeam2(){return this.team2;}
    public Team getWinner(){return this.winner;}
    public int[] getScore(){return this.score;}
    public int getMatchNumber(){return this.matchNumber;}

}
