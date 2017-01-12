package components;

/**
 * Created by jusin on 12/24/2016.
 */
public class Player {
    private String name;
    private String partner;
    private int seed;
    private String flight;
    private String event;

    public Player(String name, int seed, String flight, String event){
        this.name = name;
        this.seed = seed;
        this.flight = flight;
        this.event = event;
    }

    public String getName(){return name;}
    public String getPartner(){return partner;}
    public int getSeed(){return seed;}
    public String getFlight(){return flight;}
    public String getEvent(){return event;}
}
