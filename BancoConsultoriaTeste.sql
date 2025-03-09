create database Consultoria;
use Consultoria;

CREATE TABLE Endereco (
    idEndereco INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep VARCHAR(10) NOT NULL
);
CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    idEndereco INT NOT NULL,
    FOREIGN KEY (idEndereco) REFERENCES Endereco(idEndereco)
);
CREATE TABLE Fornecedor (
    idFornecedor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    idEndereco INT NOT NULL,
    FOREIGN KEY (idEndereco) REFERENCES Endereco(idEndereco)
);
CREATE TABLE Categoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT
);
CREATE TABLE Produto (
    idProduto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    precoProduto DECIMAL(10,2) NOT NULL,
    idCategoria INT NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria)
);
CREATE TABLE FornecedorProduto (
    idFornecedor INT NOT NULL,
    idProduto INT NOT NULL,
    precoCompra DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (idFornecedor, idProduto),
    FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(idFornecedor),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);
CREATE TABLE Estoque (
    idProduto INT PRIMARY KEY,
    quantidadeDisponivel INT NOT NULL,
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);
CREATE TABLE StatusVenda (
    idStatusVenda INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL
);
CREATE TABLE FormaPagamento (
    idFormaPagamento INT PRIMARY KEY AUTO_INCREMENT,
    tipoPagamento ENUM('PIX', 'Cartão', 'Dinheiro') NOT NULL
);
CREATE TABLE Atendente (
    idAtendente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);
CREATE TABLE Venda (
    idVenda INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    idAtendente INT NOT NULL,
    idFormaPagamento INT NOT NULL,
    idStatusVenda INT NOT NULL,
    dataVenda DATETIME NOT NULL,
    valorTotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idAtendente) REFERENCES Atendente(idAtendente),
    FOREIGN KEY (idFormaPagamento) REFERENCES FormaPagamento(idFormaPagamento),
    FOREIGN KEY (idStatusVenda) REFERENCES StatusVenda(idStatusVenda)
);
CREATE TABLE MovimentacaoEstoque (
    idMovimentacao INT PRIMARY KEY AUTO_INCREMENT,
    idProduto INT NOT NULL,
    tipoMovimentacao ENUM('Entrada', 'Saída') NOT NULL,
    quantidade INT NOT NULL,
    dataMovimentacao DATETIME NOT NULL,
    idVenda INT NULL,
    idFornecedor INT NULL,
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto),
    FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
    FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(idFornecedor)
);
CREATE TABLE ItensDeVenda (
    idItensVenda INT PRIMARY KEY AUTO_INCREMENT,
    idVenda INT NOT NULL,
    idProduto INT NOT NULL,
    quantidade INT NOT NULL,
    precoUnitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);
CREATE TABLE Encomenda (
    idEncomenda INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    dataPedido DATETIME NOT NULL,
    dataPrevistaEntrega DATETIME NOT NULL,
    valorTotal DECIMAL(10,2) NOT NULL,
    status ENUM('Pendente', 'Em Produção', 'Finalizado', 'Cancelado') NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);
CREATE TABLE ItensDeEncomenda (
    idItensEncomenda INT PRIMARY KEY AUTO_INCREMENT,
    idEncomenda INT NOT NULL,
    idProduto INT NOT NULL,
    quantidade INT NOT NULL,
    precoUnitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idEncomenda) REFERENCES Encomenda(idEncomenda),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);
CREATE TABLE Usuarios (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('admin', 'atendente') NOT NULL
);
CREATE TABLE Receitas (
    idReceita INT PRIMARY KEY AUTO_INCREMENT,
    idVenda INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    dataRecebimento DATETIME NOT NULL,
    descricao TEXT,
    FOREIGN KEY (idVenda) REFERENCES Venda(idVenda)
);
CREATE TABLE Despesas (
    idDespesa INT PRIMARY KEY AUTO_INCREMENT,
    idFornecedor INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    dataPagamento DATETIME NOT NULL,
    descricao TEXT,
    FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(idFornecedor)
);