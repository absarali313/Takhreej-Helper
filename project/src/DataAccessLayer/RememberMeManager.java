// RememberMeManager.java
package DataAccessLayer;

import TransferObjects.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RememberMeManager implements IRememberMeManager {
    // Define the file name to store Remember Me credentials
    private static final String REMEMBER_ME_FILE = "rememberMe.dat";

    // Map to store user credentials (username, password)
    private Map<String, String> userCredentials;

    // Constructor: Initializes the RememberMeManager and loads credentials from the file
    public RememberMeManager() {
        loadCredentialsFromFile();
    }

    // Load user credentials from the file into the in-memory map
    private void loadCredentialsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REMEMBER_ME_FILE))) {
            userCredentials = (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File does not exist or error reading, initialize an empty map
            userCredentials = new HashMap<>();
        }
    }

    // Save the in-memory user credentials map to the file
    private void saveCredentialsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REMEMBER_ME_FILE))) {
            oos.writeObject(userCredentials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check if the user is remembered based on the loaded credentials
    @Override
    public boolean isUserRemembered(String email) {
        return userCredentials.containsKey(email);
    }

    // Remember the user by adding their credentials to the in-memory map and saving to the file
    @Override
    public void rememberUser(User user) {
        userCredentials.put(user.getName(), user.getPassword());
        saveCredentialsToFile();
    }

    // Retrieve the user if remembered, returning a User object with the stored username and password
    @Override
    public User getUserIfRemembered(String email) {
        if (isUserRemembered(email)) {
            // For security, return a User object with the stored username and an empty password
            return new User(email, userCredentials.get(email), "", "");
        }
        return null; // User not remembered
    }
}
