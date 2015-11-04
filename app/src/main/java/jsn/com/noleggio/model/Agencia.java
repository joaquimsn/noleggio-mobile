package jsn.com.noleggio.model;

import java.io.Serializable;
import java.util.List;

public class Agencia implements Serializable{
    private static final long serialVersionUID = -339019241154666561L;

    private int idAgencia;
    private String fantasia;
    private List<Veiculo> listaVeiculo;

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public List<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }

    public void setListaVeiculo(List<Veiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agencia agencia = (Agencia) o;

        return idAgencia == agencia.idAgencia;

    }

    @Override
    public int hashCode() {
        return idAgencia;
    }
}
