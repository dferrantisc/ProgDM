package com.example.appbook.Entidades;

public class LivroEn {

    private Integer idBook;
    private String NomeLivro;
    private String AutorLivro;
    private Integer QuantidadePgsLivro;
    private String StatusLivro;

    public Integer getIdBook() { return idBook; }

    public void setIdBook(Integer idBook) { this.idBook = idBook; }

    public String getNomeLivro() {  return NomeLivro;  }

    public void setNomeLivro(String nomeLivro) {  NomeLivro = nomeLivro; }

    public String getAutorLivro() { return AutorLivro;   }

    public void setAutorLivro(String autorLivro) {   AutorLivro = autorLivro; }

    public Integer getQuantidadePgsLivro() {  return QuantidadePgsLivro;   }

    public void setQuantidadePgsLivro(Integer quantidadePgsLivro) { QuantidadePgsLivro = quantidadePgsLivro;  }

    public String getStatusLivro() {  return StatusLivro; }

    public void setStatusLivro(String statusLivro) {  StatusLivro = statusLivro;  }


}
