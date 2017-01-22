package main.logic;

import main.components.Player;
import main.components.Team;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jusin on 1/16/2017.
 * Passed a CSV file to be parsed.
 * This will only process a small subset of the data on the entry form.
 * Things such as seed will be manually added to the file.
 * CSV must be formatted in such a way of one team/player per line.
 *
 * In the future there will be another Parser class for JSON file instead of CSV.
 *
 * TO DO:
 * This class will later be implemented to parse the whole file, including contestant information.
 *
 */

public class Parser {

    BufferedReader reader;
    public Parser(String file){
        try{
            reader = new BufferedReader(new FileReader(new File(file)));
        }catch(IOException e){
            /*
            TO DO: Add better exception handling.
             */
            System.out.println("FILE CANNOT BE READ");
        }

    }

    public HashMap<String, List<Team>> parse()
    throws IOException{
        HashMap<String, List<Team>> teams = new HashMap<>();
        String line = reader.readLine();
        while(line != null){
            String[] data = line.split(",");
            String name = data[0];
            String school = data[1].toUpperCase();
            String event = data[2];
            Team team;

            if(data.length == 5){
                String partner = data[3];
                int seed = Integer.parseInt(data[4]);
                team = new Team(new Player(name, school, event, partner, seed), new Player(partner, school, event, name, seed));

            }else if(data.length == 4){

                try {
                    int seed = Integer.parseInt(data[3]);
                    team = new Team(new Player(name, school, event, seed));
                }catch(NumberFormatException e){
                    String partner = data[3];
                    team = new Team(new Player(name, school, event, partner), new Player(partner, school, event, name));
                }


            }else{
                team = new Team(new Player(name, school, event));
            }

            if(teams.containsKey(event)){
                List<Team> list = teams.get(event);
                list.add(team);
            }else{
                teams.put(event, new LinkedList<>(Arrays.asList(team)));
            }

            line = reader.readLine();
        }
        reader.close();
        return teams;
    }
}
