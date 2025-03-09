package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class ControllerMenu {

    @FXML private Button btnVenda;
    @FXML private Button btnCliente;
    @FXML private Button btnFornecedor;
    @FXML private Button btnDespesa;
    @FXML private Button btnDespesaXreceitas;
    @FXML private Button btnProdutosVendidos;
    @FXML private Button btnEstoque;
    @FXML private Button btnProduto;
    @FXML private Button btnContasAPagar;
    @FXML private Button btnAgenda;
    @FXML private Button btnVideoAula;
    @FXML private AnchorPane contentPaneMenu;

    private void abrirTela(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/" + fxmlFile));
            AnchorPane newContent = loader.load();

            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);

            contentPaneMenu.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + fxmlFile);
        }
    }

    @FXML private void abrirTelaVenda() {
        abrirTela("FrameVenda.fxml");
    }

    @FXML private void abrirTelaCliente() {
        abrirTela("FrameCliente.fxml");
    }

    @FXML private void abrirTelaFornecedor() {
        abrirTela("FrameFornecedor.fxml");
    }

    @FXML private void abrirTelaDespesa() {
        abrirTela("FrameDespesa.fxml");
    }

    @FXML private void abrirTelaProduto() {
        abrirTela("FrameProduto.fxml");
    }

    @FXML private void abrirTelaEstoque() {
        abrirTela("FrameEstoque.fxml");
    }

    @FXML private void abrirTelaListaVendas() {
        abrirTela("FrameListaVendas.fxml");
    }
}
