
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;

public class FxHistoryController implements Initializable {

    @FXML
    private TextArea txtHistory;

    @FXML
    private Button btnHide;

    @FXML
    private Button btnClear;

    private NyrData nyrData;

    public void showWindow() {
        Stage window = (Stage) btnHide.getScene().getWindow();
        window.show();
    }

    public void setModel(NyrData nyrData) {
        this.nyrData = nyrData;
        nyrData.addListener((nd) -> {
            List<String> historyList = nyrData.getHistory();
            StringBuilder historyContent = new StringBuilder("");
            for (String oneItem : historyList) {
                // concatinate data
                historyContent.append(oneItem + "\n");

            }
            txtHistory.setText(historyContent.toString());
        });
        System.out.println("History Controller setModel complete");
    }

    /*
     * Initializes controller class
     * .
     * .
     * .
     * .
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Auto-generated method stub

    }

    @FXML
    private void onclickHide(ActionEvent event) {
        Window window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.hide();
    }

    @FXML
    private void onclickClear(ActionEvent event) {
        nyrData.clearHistory();
    }

}
