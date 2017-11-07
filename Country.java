import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * Write a description of class Country here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Country
{
    private Map<City,List<Road>> network;
    private String name;
    private Country country;

    public Country(Map<City, List<Road>> network, String name) {
        this.network = network;
        this.name = name;
    }

    public Map<City, List<Road>> getNetwork() {
        return network;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public List<Road> getRoads(City city){
        return network.get(city);
    }

    public List<City> getCities(){
        List<City> cities  = new ArrayList<>(network.keySet());
        Collections.sort(cities);
        return cities;
    }

    public City getCity(String name){
        for (City city : getCities() ){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    public void reset(){
        network.clear();
    }

    // Beregner størrelsen af den bonus, som spilleren modtager.
    public int bonus(int value){
        if(value>0){
            Random r = new Random();
            return r.nextInt(value) + 0;

        }
        return 0;
    }

    //Tilføjer veje mellem a og b.
    public void addRoads(City a, City b, int length){
        if(network.containsKey(a) && network.containsKey(b)){
            Road roadab = new Road(a,b,length);
            Road roadba = new Road(b,a,length);
            network.get(a).add(roadab);
            network.get(b).add(roadba);
        } else if(network.containsKey(a)|| network.containsKey(b)){
            if(network.containsKey(a)) {
                Road roadab = new Road(a, b, length);
                network.get(a).add(roadab);
            }else{
                Road roadba = new Road(b,a,length);
                network.get(b).add(roadba);
            }
        }
    }

    // returnerer byens position.
    public Position position(City city){
        return new Position(city, city, 0);

    }

    // Gør klar til at påbegynde rejse.
    public Position readyToTravel(City from, City to){

        if(!from.equals(to)){
            for (Road road : getRoads(from)) {
                if(road.getTo().equals(to)){
                    return new Position(from, to, road.getLength());
                }
            }
        }
            return position(from);
    }
}

