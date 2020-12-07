import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> hashMap;

    public VehicleRegistry() {
        hashMap = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (!(hashMap.containsKey(licensePlate))) {
            hashMap.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate){
        return hashMap.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate){
        if(hashMap.containsKey(licensePlate)){
            hashMap.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates(){
        for(LicensePlate licensePlate:hashMap.keySet()){
            System.out.println(licensePlate.toString());
        }
    }

    public void printOwners(){
        ArrayList<String> alreadyPrinted = new ArrayList<>();
        for(String owner:hashMap.values()){
            if(!(alreadyPrinted.contains(owner))){
                alreadyPrinted.add(owner);
                System.out.println(owner);
            }
        }
    }


}
