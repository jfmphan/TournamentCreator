package components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Team {
    private Player player1 = null;
    private Player player2 = null;

    public Team(Player player1){
        this.player1 = player1;
    }

    public Team(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1(){return this.player1;}
    public Player getPlayer2(){return this.player2;}
}
