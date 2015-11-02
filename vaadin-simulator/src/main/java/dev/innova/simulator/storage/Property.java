package dev.innova.simulator.storage;

/**
 * Created by sajith on 10/30/15.
 */
public class Property {
    private String apiKey;
    private String registrationId;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public String toString() {
        return "Property{" +
                "apiKey='" + apiKey + '\'' +
                ", registrationId='" + registrationId + '\'' +
                '}';
    }
}
