package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerDespesa {

    @FXML private Button btnConsulta;
    @FXML private Button btnExcluir;
    @FXML private Button btnSalvar;
    @FXML private Button btnVolta;
    @FXML private DatePicker dateDespesa;
    @FXML private TextField txtNomeDespesa;
    @FXML private TextArea txtObservacao;
    @FXML private TextField txtValor;
    @FXML private AnchorPane contentPaneDespesa;

    private void abrirTela(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/" + fxmlFile));
            AnchorPane newContent = loader.load();

            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);

            contentPaneDespesa.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela" + fxmlFile);
        }
    }

    @FXML private void voltarParaMenu() {
        abrirTela("FrameMenu.fxml");
    }

    @FXML private void abrirTelaListaDespesa() {
        abrirTela("FrameListaDespesas.fxml");
    }
}
