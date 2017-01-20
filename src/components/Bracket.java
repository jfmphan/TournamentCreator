package components;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jusin on 12/24/2016.
 *
 * Organizes all the matches together into the bracket.
 */
public class Bracket {

    private List<Team> teams;
    private List<Match> matches;
    public Bracket(List<Team> teams) {
        this.teams = teams;
        matches = new LinkedList<>();
    }

    // Logic that shuffles the matches in an order that represents the tournament bracket.
    // Manipulates the matches bracket.
    public List<Match> makeBracket(){
        makeMatches();
        Match[] tempMatches = new Match[matches.size()];


        return matches;
    }

    // Helper method that pairs players together into match.
    // Manipulates the teams list. (Teams may represent 1 or 2 players).
    /*
        Rules of matches:
        - Two teams cannot be seeded.
        - Two teams cannot be affiliated.
        - Seeded players get "byes" first.
     */
    private void makeMatches(){
        int byeCounter = getByeCounter();
        int seeded = 4;
        int i = 0;
        int j = 1;

        while(i < teams.size() && j < teams.size()){

            Team teamOne = teams.get(i);
            Team teamTwo = teams.get(j);

            // Gives every seeded team a BYE.
            /*
            TO DO: Refactor into DRY design.
             */
            if(teamOne.getSeeding() > 0 && byeCounter > 0){
                matches.add(new Match(teamOne, new Team(), i));
                byeCounter--;
                teams.remove(teamOne);
                seeded--;
            }else if(teamTwo.getSeeding() > 0 && byeCounter > 0){
                matches.add(new Match(teamTwo, new Team(), i));
                byeCounter--;
                teams.remove(teamTwo);
                seeded--;
            }else if (!teamOne.getSchool().equalsIgnoreCase(teamTwo.getSchool())){
                matches.add(new Match(teamOne, teamTwo, i));
                teams.remove(teamOne);
                teams.remove(teamTwo);
            }else if (seeded < byeCounter){
                matches.add(new Match(teamOne, new Team(), i));
                byeCounter--;
                teams.remove(teamOne);
            }else{
                j++;
            }
        }

    }

    private int getByeCounter(){
        return (int) Math.ceil((Math.log(teams.size())/Math.log(2))) - teams.size();
    }

    public List<Match> getMatches(){return matches;}

}
