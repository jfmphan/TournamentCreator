import main.components.Bracket;
import main.components.Match;
import main.components.Player;
import main.components.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jusin on 1/20/2017.
 */
class BracketTest {

    private Bracket bracket;
    private List<Team> teams = new LinkedList<>();
    @BeforeEach
    void setUp() {
        Player playerOne = new Player("James","UCI", "AMS", 1);
        Player playerTwo = new Player("Cordon","UCD",  "AMS", 3);
        Player playerThree = new Player("Bourbon","UCI",  "AMS", 4);
        Player playerFour = new Player("Matthews","UCSD",  "AMS", 2);
        Player playerFive = new Player("Malek","UCB", "AMS");

        teams.add(new Team(playerOne));
        teams.add(new Team(playerTwo));
        teams.add(new Team(playerThree));
        teams.add(new Team(playerFour));
        teams.add(new Team(playerFive));


    }
    /*
    The bye count should be 2^ Log2(#ofPlayers)(rounded up) - # of players;
     */
    @Test
    void getByeCounter(){

        teams.add(new Team(new Player("Bobby", "UBS", "AMS")));
        teams.add(new Team(new Player("Carl", "UBS", "AMS")));
        teams.add(new Team(new Player("Cid", "UBS", "AMS")));
        teams.add(new Team(new Player("Brandon", "UBS", "AMS")));
        teams.add(new Team(new Player("Brian", "UBS", "AMS")));
        bracket = new Bracket(teams);
        assert bracket.getByeCounter() == 6;
    }

    /*
    The size of 'matches' will always be half of the amount of needed players to complete a bracket.
    Which is # of players + bye count.
     */
    @Test
    void makeMatches(){

        teams.add(new Team(new Player("Bobby", "UBS", "AMS")));
        teams.add(new Team(new Player("Carl", "UBS", "AMS")));
        teams.add(new Team(new Player("Cid", "UBS", "AMS")));
        teams.add(new Team(new Player("Brandon", "UBS", "AMS")));
        teams.add(new Team(new Player("Brian", "UBS", "AMS")));
        bracket = new Bracket(teams);
        bracket.makeMatches();
        List<Match> matches = bracket.getMatches();

        assert matches.size() == 8;

    }

    @Test
    void makeBracket() {

        teams.add(new Team(new Player("Bobby", "UBS", "AMS")));
        teams.add(new Team(new Player("Carl", "UBS", "AMS")));
        teams.add(new Team(new Player("Cid", "UBS", "AMS")));
        teams.add(new Team(new Player("Brandon", "UBS", "AMS")));
        teams.add(new Team(new Player("Brian", "UBS", "AMS")));

        bracket = new Bracket(teams);
        List<Match> matches = bracket.makeBracket();

        assert matches.size() == 8;
    /*
        for(int i = 0; i < matches.size(); i++){
            System.out.println(matches.get(i).getTeam1().getPlayer1().getName() + " vs " + matches.get(i).getTeam2().getPlayer1().getName());
        }
    */
    }

}