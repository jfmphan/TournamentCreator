package main.components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Team {

    private Player player1 = null;
    private Player player2 = null;
    private int seeding;

    public Team(){
        // Represents a "BYE". May later properly define a "BYE" without it meaning a string.
        player1 = new Player();
    }

    public Team(Player player1){
        this.player1 = player1;
        this.seeding = player1.getSeed();
    }

    public Team(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.seeding = player1.getSeed();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(player1.getName() + ", ");
        builder.append(player1.getSchool() + ", ");
        builder.append(player1.getEvent() + ", ");
        builder.append(player1.getPartner() + ", ");
        builder.append(player1.getSeed());

        return builder.toString();
    }

    public Player getPlayer1(){return this.player1;}
    public Player getPlayer2(){return this.player2;}
    public int getSeeding(){return this.seeding;}
    public String getSchool(){return player1.getSchool();}
}
