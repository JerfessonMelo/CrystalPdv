package Entidades;

import java.time.LocalDateTime;

public class MovimentacaoEstoque extends Base {
    
    private int quantidade;
    private LocalDateTime dataMovimentacao = LocalDateTime.now();
    private Produto produto;
    private TipoMovimentacao TipoMovimentacao;

}
