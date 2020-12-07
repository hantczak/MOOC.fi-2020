import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {
        storage.putIfAbsent(unit, new ArrayList<>());
        storage.get(unit).add(item);
    }


    public ArrayList<String> contents(String storageUnit) {
        if (!(storage.containsKey(storageUnit))) {
            return new ArrayList<>();
        }

        ArrayList<String> contents = new ArrayList<>();
        for (String item : storage.get(storageUnit)) {
            contents.add(item);
        }
        return contents;
    }

    public void remove(String storageUnit, String item) {
        storage.get(storageUnit).remove(item);
        if (storage.get(storageUnit).isEmpty()) {
            storage.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsNames = new ArrayList<>();
        for (String unit : storage.keySet()) {
            if (!(unitsNames.contains(unit))) {
                if (!(storage.get(unit).isEmpty())) {
                    unitsNames.add(unit);
                }
            }
        }
        return unitsNames;
    }
}
