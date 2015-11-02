package dev.innova.simulator.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sajith on 10/30/15.
 */
public class PropertyHolder {
    private Map<Integer, Property> propertyIntegerMap;

    public PropertyHolder() {
        propertyIntegerMap = new HashMap<>();
    }

    public void insertSettings(Property property) {
        propertyIntegerMap.put(0, property);
    }

    public Property getSettings() {
        return propertyIntegerMap.get(0);
    }
}
