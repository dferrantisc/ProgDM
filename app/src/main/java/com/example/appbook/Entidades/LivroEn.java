package com.example.appbook.Entidades;

import android.widget.CheckBox;
import android.widget.EditText;

public class LivroEn {


    private Integer idL;
    private String NomeL;
    private String AutorL;
    private String QuantidadePgsL;
    private boolean Lido;
    private boolean Lendo;


    public Integer getIdL() {return idL; }

    public void setIdL(Integer idL) { this.idL = idL; }

    public String getNomeL() {
        return NomeL;
    }

    public void setNomeL(String nomeL) {
        NomeL = nomeL;
    }

    public String getAutorL() {
        return AutorL;
    }

    public void setAutorL(String autorL) {
        AutorL = autorL;
    }

    public String getQuantidadePgsL() {
        return QuantidadePgsL;
    }

    public void setQuantidadePgsL(String quantidadePgsL) {
        QuantidadePgsL = quantidadePgsL;
    }

    public boolean isLido() {
        return Lido;
    }

    public void setLido(boolean lido) {
        Lido = lido;
    }

    public boolean isLendo() {
        return Lendo;
    }

    public void setLendo(boolean lendo) {
        Lendo = lendo;
    }
}
