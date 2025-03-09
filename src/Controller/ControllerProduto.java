package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerProduto {

    @FXML private Button btnVolta;
    @FXML private Button btnExcluir;
    @FXML private Button btnConsulta;
    @FXML private Button btnSalvar;
    @FXML private TextField txtNomeProduto;
    @FXML private TextField txtCodigoBarras;
    @FXML private TextField txtCodigoBarras1;
    @FXML private TextArea txtDescricao;
    @FXML private AnchorPane contentPaneProduto;


    private void abrirTela(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/" + fxmlFile));
            AnchorPane newContent = loader.load();

            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);

            contentPaneProduto.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + fxmlFile);
        }
    }

        @FXML private void voltarParaMenu() {
        abrirTela("FrameMenu.fxml");
    }  
        @FXML private void abrirTelaListaProduto() {
        abrirTela("FrameListaProdutos.fxml");
    }  
}
