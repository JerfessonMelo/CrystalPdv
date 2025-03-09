package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerFornecedor {

    @FXML private Button btnConsulta;
    @FXML private Button btnExcluir;
    @FXML private Button btnSalvar;
    @FXML private Button btnVolta;
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtCpfCnpj;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtCidade;
    @FXML private TextField txtBairro;
    @FXML private AnchorPane contentPaneFornecedor;

    private void abrirTela(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/" + fxmlFile));
            AnchorPane newContent = loader.load();

            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);

            contentPaneFornecedor.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + fxmlFile);
        }
    }

    @FXML private void voltarParaMenu(){
      abrirTela("FrameMenu.fxml");  
    }

    @FXML private void abrirTelaListaFornecedor(){
        abrirTela("FrameListaFornecedor.fxml");
    }

}
