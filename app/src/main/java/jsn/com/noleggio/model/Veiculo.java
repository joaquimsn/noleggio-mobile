package jsn.com.noleggio.model;

import java.io.Serializable;
import java.text.NumberFormat;

import jsn.com.noleggio.SystemUtil;
import jsn.com.noleggio.enums.GrupoVeiculoEnum;
import jsn.com.noleggio.enums.StatusVeiculoEnum;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = -5441014637855806050L;

    private int idVeiculo;
    private String modelo;
    private String fabricante;
    private int grupo;
    private int status;
    private double precoKmLivre;
    private double precoKmControlado;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public GrupoVeiculoEnum getGrupo() {
        return GrupoVeiculoEnum.getEnumByValue(grupo);
    }

    public void setGrupo(GrupoVeiculoEnum grupo) {
        this.grupo = grupo.getValue();
    }

    public StatusVeiculoEnum getStatus() {
        return StatusVeiculoEnum.getEnumByValue(status);
    }

    public void setStatus(StatusVeiculoEnum statusVeiculoEnum) {
        this.status = statusVeiculoEnum.getValue();
    }

    public double getPrecoKmLivre() {
        return precoKmLivre;
    }

    public void setPrecoKmLivre(double precoKmLivre) {
        this.precoKmLivre = precoKmLivre;
    }

    public double getPrecoKmControlado() {
        return precoKmControlado;
    }

    public void setPrecoKmControlado(double precoKmControlado) {
        this.precoKmControlado = precoKmControlado;
    }

    public String getPrecoKmControladoDisplay() {
        return NumberFormat.getCurrencyInstance(SystemUtil.LOCALE_BRASIL).format(precoKmControlado);
    }

    public String getPrecoKmLivreDisplay() {
        return NumberFormat.getCurrencyInstance(SystemUtil.LOCALE_BRASIL).format(precoKmLivre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;

        return idVeiculo == veiculo.idVeiculo;

    }

    @Override
    public int hashCode() {
        return idVeiculo;
    }
}
