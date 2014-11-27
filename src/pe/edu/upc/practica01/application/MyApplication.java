package pe.edu.upc.practica01.application;
import android.app.Application;
public class MyApplication extends Application {

    private boolean loggedIn = false;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
