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

    public int bonus(int value){
        int bonus;
        Random r = new Random();
        bonus = r.nextInt(value)+0;
        return bonus;
    }

}
