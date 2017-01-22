package main.components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Player {
    private String name;
    private String event;
    private String school;

    private String partner = "";
    private int seed = 0;

    public Player(){
        this.name = "BYE";
        this.partner = "BYE";
        this.event = "BYE";
        this.school = "BYE";

    }
    public Player(String name, String school,  String event, int seed){
        this.name = name;
        this.seed = seed;
        this.event = event;
        this.school = school;
    }

    public Player(String name, String school,  String event){
        this.name = name;
        this.event = event;
        this.school = school;
    }

    public Player(String name, String school, String event, String partner, int seed){
        this.name = name;
        this.seed = seed;
        this.event = event;
        this.partner = partner;
        this.school = school;
    }

    public Player(String name, String school, String event, String partner){
        this.name = name;
        this.event = event;
        this.partner = partner;
        this.school = school;
    }

    public String getName(){return name;}
    public String getPartner(){return partner;}
    public int getSeed(){return seed;}
    public String getEvent(){return event;}
    public String getSchool(){return school;}
}
