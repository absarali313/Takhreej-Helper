// RememberMeManager.java
package DataAccessLayer;

import TransferObjects.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RememberMeManager implements IRememberMeManager {
    private static final String REMEMBER_ME_FILE = "rememberMe.dat";

    private Map<String, String> userCredentials;

    public RememberMeManager() {
        loadCredentialsFromFile();
    }

    private void loadCredentialsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REMEMBER_ME_FILE))) {
            userCredentials = (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File does not exist or error reading, initialize an empty map
            userCredentials = new HashMap<>();
        }
    }

    private void saveCredentialsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REMEMBER_ME_FILE))) {
            oos.writeObject(userCredentials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserRemembered(String email) {
        return userCredentials.containsKey(email);
    }

    @Override
    public void rememberUser(User user) {
        userCredentials.put(user.getName(), user.getPassword());
        saveCredentialsToFile();
    }

    @Override
    public User getUserIfRemembered(String email) {
        if (isUserRemembered(email)) {
            return new User(email, userCredentials.get(email), "", "");
        }
        return null;
    }
}
