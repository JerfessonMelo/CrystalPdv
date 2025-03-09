package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ControllerCliente {

    @FXML private TextField txtBuscarCliente;
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtCep;
    @FXML private TextField txtBairro;
    @FXML private TextField txtCidade;
    @FXML private DatePicker dateNascimento;
    @FXML private Button btnVolta;
    @FXML private Button btnSalvar;
    @FXML private Button btnConsulta;
    @FXML private Button btnExcluir;
    @FXML private AnchorPane contentPaneCliente;

    private void abrirTela(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/" + fxmlFile));
            AnchorPane newContent = loader.load();

            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);

            contentPaneCliente.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + fxmlFile);
        }
    }

    @FXML private void abrirTelaListaCliente() {
    abrirTela("FrameListaClientes.fxml");
    }

    @FXML private void voltarParaMenu() {
        abrirTela("FrameMenu.fxml");
    }
}
