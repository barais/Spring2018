package sample.aop.security;

import org.apache.commons.logging.Log;

import java.util.logging.Logger;

/**
 * Class {@link SecurityManager}, that contains {@link UserManager}
 * Allow check if user is connected.
 */
public class SecurityManager {
    private static final ThreadLocal<UserManager> threadLocal = new ThreadLocal<>();

    public static void login(String id, String passwd){
        threadLocal.set(new UserManager(id, passwd));
    }

    public static String getId() {
        return threadLocal.get() != null ? threadLocal.get().getId() : "null";
    }

    public static void logout(){
        Logger.getGlobal().info(String.format("Logout for user: %s", threadLocal.get().getId()));
        threadLocal.remove();

    }

    public static boolean isConnected(){
        return threadLocal.get() != null;
    }

    // mocks a user from a security lib
    public static class UserManager {
        private String id, password;

        public UserManager(String id, String passwd) {
            this.id = id;
            this.password = passwd;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}