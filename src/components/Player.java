package components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Player {
    private String name;
    private String partner;
    private int seed = 0;

    private String event;
    private String school;

    public Player(String name, String school, int seed, String event){
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

    public Player(String name, int seed, String event, String partner){
        this.name = name;
        this.seed = seed;
        this.event = event;
        this.partner = partner;
    }

    public String getName(){return name;}
    public String getPartner(){return partner;}
    public int getSeed(){return seed;}
    public String getEvent(){return event;}
    public String getSchool(){return school;}
}
