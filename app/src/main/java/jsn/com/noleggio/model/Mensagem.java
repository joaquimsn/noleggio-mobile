package jsn.com.noleggio.model;

import java.io.Serializable;

/**
 * Objeto para troca de mensagens simples entre telas
 */
public class Mensagem implements Serializable {
    private static final long serialVersionUID = -7015804291736832334L;

    private String titulo;
    private String detalhe;

    public Mensagem() {
        this.titulo = "";
        this.detalhe = "";
    }

    public Mensagem(String titulo, String detalhe) {
        this.titulo = titulo;
        this.detalhe = detalhe;
    }

    /**
     * @return Título da mensagem
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo Título da mensagem
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return Detalhe da mensagem
     */
    public String getDetalhe() {
        return detalhe;
    }

    /**
     * @param detalhe Detalhe da mensagem
     */
    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}
