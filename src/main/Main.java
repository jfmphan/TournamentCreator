package main;

import main.components.Bracket;
import main.components.Match;
import main.components.Team;
import main.logic.Parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jusin on 12/24/2016.
 */
public class Main {

    public static void main(String[] args){
        if(args.length <=0){
            System.out.println("FILE NOT FOUND");
        }else{
            String file = args[0];
            Parser parser = new Parser(file);
            List<List<Match>> tournament = new LinkedList<>();
            try{
                HashMap<String, List<Team>> teams = parser.parse();
                for(List<Team> l : teams.values()){
                    Bracket bracket = new Bracket(l);
                 /*   for(Team t: l){
                        System.out.println(t.toString());
                    }
                */
                    tournament.add(bracket.makeBracket());
                }

                for(List<Match> l : tournament){
                    for(Match m : l){
                        System.out.println(m.getTeam1().toString() + " vs " + m.getTeam2().toString());
                    }
                    System.out.println("\n");
                }
            }catch(IOException e){
                System.out.println("FILE NOT FOUND WHILE READING");
            }
        }

    }
}
