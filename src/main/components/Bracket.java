package main.components;

import java.util.Arrays;
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
    /*
        Rules:
        - Seeded matches must stay on opposite sides of the bracket.
        - Under the assumption that there are still only 4 seeded players at one time.
     */
    public List<Match> makeBracket(){
        makeMatches();
        Match[] tempMatches = new Match[matches.size()];
        int[] positions = new int[4];
        positions[1] = matches.size() / 2 - 1;
        positions[2] = matches.size() / 2;
        positions[3] = matches.size() - 1;
        int p = 0;
        int arrCount = 1;

        for(int i = 0; i < matches.size(); i++){

            int teamSeedOne = matches.get(i).getTeam1().getSeeding();
            int teamSeedTwo = matches.get(i).getTeam2().getSeeding();
            int seed =  teamSeedOne >  teamSeedTwo ? teamSeedOne : teamSeedTwo;

        //    System.out.println( matches.get(i).getTeam1().getPlayer1().getName() + " " + matches.get(i).getTeam2().getPlayer1().getName());

            if(seed > 0 && p < 4){
                tempMatches[positions[p]] = matches.get(i);
        //        System.out.println("Added " + positions[p]);
                p++;
            }else{
                while(arrCount == positions[1] || arrCount == positions[2]){
                    arrCount++;
                }
         //       System.out.println("Added " + arrCount);
                tempMatches[arrCount++] = matches.get(i);
            }
        }

        return new LinkedList<>(Arrays.asList(tempMatches));
    }

    // Helper method that pairs players together into match.
    // Manipulates the teams list. (Teams may represent 1 or 2 players).
    /*
        Rules of matches:
        - Two teams cannot be seeded.
        - Two teams cannot be affiliated. (Currently not a factor)
        - Seeded players get "byes" first.
     */
    public void makeMatches(){
        int byeCounter = getByeCounter();

    //    System.out.println("Bye counter: " + byeCounter);

        int matchCounter = setByeMatches(byeCounter, 1);
    //    System.out.println(teams.size());

        /*
        TO DO: Change it to a normal iterator, while teams.size
         */

        while(teams.size() >= 2){

            Team teamOne = teams.get(0);
            Team teamTwo = teams.get(1);


            matches.add(new Match(teamOne, teamTwo, matchCounter++));
            teams.remove(teamOne);
            teams.remove(teamTwo);

        //    System.out.println("TeamOne " + teamOne.getPlayer1().getName());
        //    System.out.println("TeamTwo: " + teamTwo.getPlayer1().getName());
        }

    }


    protected int setByeMatches(int byeCounter, int matchCounter){

        for(int i = 0; i < teams.size();){



            if(byeCounter <= 0){
                break;
            }
            if(teams.get(i).getSeeding() > 0){
                byeCounter--;
            //    System.out.println("Adding player: " + teams.get(i).getPlayer1().getName());
                matches.add(new Match(teams.get(i), new Team(), matchCounter++));
                teams.remove(teams.get(i));
            }else{
                i++;
            }

        }

        if(byeCounter > 0){
            for(int i = 0; i < byeCounter && i < teams.size(); i++){
                matches.add(new Match(teams.get(i), new Team(), matchCounter++));
            //    System.out.println(teams.get(i).getPlayer1().getName());
                teams.remove(teams.get(i));
            }
        }

        return matchCounter;
    }


    public int getByeCounter(){
        double base = Math.ceil((Math.log(teams.size())/Math.log(2)));
        return (int) Math.pow(2.0, base) - teams.size();
    }



    public List<Match> getMatches(){return matches;}

}
