
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FxNyResolutionsController implements Initializable {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnOops;

    @FXML
    private Label lblResolution1;

    @FXML
    private Label lblResolution2;

    @FXML
    private Label lblResolution3;

    @FXML
    private Label lblResolution4;

    @FXML
    private Label lblResolution5;

    private NyrData nyrData;

    private Label[] labels = new Label[5];

    private FxHistoryController historyController;

    public void setHistoryController(FxHistoryController historyController) {
        this.historyController = historyController;
    }

    public void setModel(NyrData nyrData) {
        this.nyrData = nyrData;

        nyrData.addListener((nd) -> {
            List<String> resolutions = nyrData.getUnconfirmedResolutions();
            for (int idx = 0; idx < labels.length; ++idx) {
                // System.out.println("Updating label " + idx);
                if (idx < resolutions.size()) {
                    labels[idx].setText(resolutions.get(idx));
                } else {
                    labels[idx].setText("");
                }

            } // for

        });
        System.out.println("Nyr Controller setModel complete");

    }

    public void notifyObservers() {

        nyrData.notifyObservers();
    }

    /*
     * Initialize controller class
     * .
     * .
     * .
     * 
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labels[0] = lblResolution1;
        labels[1] = lblResolution2;
        labels[2] = lblResolution3;
        labels[3] = lblResolution4;
        labels[4] = lblResolution5;
        System.out.println("Labels initialized");
    }

    @FXML
    private void onclickDone(ActionEvent event) {
        nyrData.confirm();
        historyController.showWindow();

    }

    @FXML
    private void onclickOops(ActionEvent event) {
        nyrData.oops();
        historyController.showWindow();
    }
}
