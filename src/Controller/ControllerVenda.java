package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerVenda {

    @FXML private Button btnCancelarVenda;
    @FXML private Button btnConfirmaVenda;
    @FXML private Button btnVolta;
    @FXML private TableColumn<?, ?> tableProduto;
    @FXML private TableColumn<?, ?> tableQuantidade;
    @FXML private TableColumn<?, ?> tableValor;
    @FXML private TextField txtCliente;
    @FXML private TextField txtProduto;
    @FXML private AnchorPane contentPaneVenda;

    @FXML
    public void initialize() {
        btnVolta.setOnAction(_ -> voltarParaMenu());
    }

    private void voltarParaMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/FrameMenu.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnVolta.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
