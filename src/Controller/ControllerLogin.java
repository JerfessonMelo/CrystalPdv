package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerLogin {

    @FXML private Button btnEntrar;
    @FXML private PasswordField txtSenha;
    @FXML private TextField txtUsuario;
    @FXML private AnchorPane contentPaneLogin;

    @FXML
    public void initialize() {
        btnEntrar.setOnAction(_ -> validarLogin());
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if ("admin".equals(usuario) && "1234".equals(senha)) {
            abrirTelaMenuPrincipal();
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro de Login");
            alerta.setHeaderText("Usuário ou senha incorretos!");
            alerta.show();
        }
    }

    private void abrirTelaMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/FrameMenu.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
            stage.setScene(new Scene(root));
            stage.show();

            Stage loginStage = (Stage) btnEntrar.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
