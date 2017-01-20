package test

import components.Bracket
import components.Player
import components.Team

/**
 * Created by jusin on 1/20/2017.
 */
class BracketTest extends GroovyTestCase {
    void testMakingMatches(){
        def playerOne = new Player("James","UCI", 1, "AMS")
        def playerTwo = new Player("Cordon","UCD", 3, "AMS")
        def playerThree = new Player("Bourbon","UCI", 4, "AMS")
        def playerFour = new Player("Matthews","UCSD", 2, "AMS")
        def playerFive = new Player("Malek","UCB", "AMS")

        def teams = new LinkedList<Team>()
        teams.add(new Team(playerOne))
        teams.add(new Team(playerTwo))
        teams.add(new Team(playerThree))
        teams.add(new Team(playerFour))
        teams.add(new Team(playerFive))
        def bracket = new Bracket(teams)
        def matches = bracket.makeBracket()
        assert matches.size() == 5
    }
}
