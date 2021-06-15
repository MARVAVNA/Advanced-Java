import java.io.*;

public class UserService {

    public static final String USER_FILE_NAME = "user";

    public static void serializeUser(User user) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(USER_FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static User deserializeUser() {
        User result = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(USER_FILE_NAME);
            ois = new ObjectInputStream(fis);
            result = (User) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
