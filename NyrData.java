
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NyrData {
    public interface Listener {

        void onChange(NyrData nyrData);

    }// interface listener

    private List<Listener> listeners = new ArrayList<>();

    private LinkedList<String> unconfirmedResolutions = new LinkedList<String>();
    private ArrayList<String> confirmedResolutions = new ArrayList<String>();
    private ArrayList<String> history = new ArrayList<String>();

    // method adds data to the list of Unconfirmed Resolutions
    public NyrData() {

        unconfirmedResolutions.add("start running");
        unconfirmedResolutions.add("go to the gym");
        unconfirmedResolutions.add("get 8 hours of sleep");
        unconfirmedResolutions.add("eat healthy");
        unconfirmedResolutions.add("be on time for work");

    }// NyrData

    public void addListener(Listener listener) {
        listeners.add(listener);

    }

    public void notifyObservers() {
        listeners.stream().forEach(ls -> ls.onChange(this));
    }

    // take unconfirmed list and move it to confirmed list
    // Update history
    void confirm() {

        if (unconfirmedResolutions.contains("start running")) {
            unconfirmedResolutions.remove(0);
            confirmedResolutions.add("start running");
            history.add(" CONFIRMED: start running");
        } else if (unconfirmedResolutions.contains("go to the gym")) {
            unconfirmedResolutions.remove(0);
            confirmedResolutions.add("go to the gym");
            history.add(" CONFIRMED: go to the gym");
        } else if (unconfirmedResolutions.contains("get 8 hours of sleep")) {
            unconfirmedResolutions.remove(0);
            confirmedResolutions.add("get 8 hours of sleep");
            history.add("CONFIRMED: get 8 hours of sleep");

        } else if (unconfirmedResolutions.contains("eat healthy")) {
            unconfirmedResolutions.remove(0);
            confirmedResolutions.add("eat healthy");
            history.add("CONFIRMED: eat healthy");
        } else if (unconfirmedResolutions.contains("be on time for work")) {
            unconfirmedResolutions.remove(0);
            confirmedResolutions.add("be on time for work");
            history.add("CONFIRMED: be on time for work");

        } else if ((unconfirmedResolutions.size() == 0)) {
            history.add("ERROR: Nothing to confirm");
        }
        notifyObservers();
    }

    // take confirmed and move it to unconfirmed
    // Update history

    void oops() {

        if (!unconfirmedResolutions.contains("start running") && unconfirmedResolutions.size() == 4) {
            confirmedResolutions.remove("start running");
            unconfirmedResolutions.addFirst("start running");
            history.add("UNCONFIRMED: start running");
        } else if (!unconfirmedResolutions.contains("go to the gym") && unconfirmedResolutions.size() == 3) {
            confirmedResolutions.remove("go to the gym");
            unconfirmedResolutions.addFirst("go to the gym");
            history.add("UNCONFIRMED: go to the gym");

        } else if (!unconfirmedResolutions.contains("get 8 hours of sleep") && unconfirmedResolutions.size() == 2) {
            confirmedResolutions.remove("get 8 hours of sleep");
            unconfirmedResolutions.addFirst("get 8 hours of sleep");
            history.add("UNCONFIRMED: get 8 hours of sleep");

        } else if (!unconfirmedResolutions.contains("eat healthy") && unconfirmedResolutions.size() == 1) {
            confirmedResolutions.remove("eat healthy");
            unconfirmedResolutions.addFirst("eat healthy");
            history.add("UNCONFIRMED: eat healthy");

        } else if (!unconfirmedResolutions.contains("be on time for work") && unconfirmedResolutions.size() == 0) {
            confirmedResolutions.remove("be on time for work");
            unconfirmedResolutions.addFirst("be on time for work");
            history.add("UNCONFIRMED: be on time for work");

        } else if (unconfirmedResolutions.size() == 5) {
            history.add("ERROR: Nothing to unconfirm");
        }
        notifyObservers();
    } // oops

    public void clearHistory() {

        history.clear();

        notifyObservers();

    }// clear history

    public LinkedList<String> getUnconfirmedResolutions() {
        return unconfirmedResolutions;
    }// getUnconfirmedResolutions

    public ArrayList<String> getConfirmedResolutions() {
        return confirmedResolutions;
    }// getConfirmedResolutions

    public ArrayList<String> getHistory() {
        return history;
    }// getHistory
}// class NyrData