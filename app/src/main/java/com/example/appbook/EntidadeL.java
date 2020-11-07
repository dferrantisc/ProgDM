package com.example.appbook;

import android.widget.CheckBox;
import android.widget.EditText;

public class EntidadeL {

    private String NomeL;
    private String AutorL;
    private String QuantidadePgsL;
    private boolean Lido;
    private boolean Lendo;

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
