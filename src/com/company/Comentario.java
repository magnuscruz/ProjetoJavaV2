import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Comentario implements Serializable {
    private String opniao;
    private double pontuacao;
    private Cliente cliente;
    private Restaurante restaurante;
    private GregorianCalendar data;
    private int dia;
    private int mes;
    private int ano;

    public Comentario(String opniao, double pontuacao, Cliente cliente, Restaurante restaurante, int dia, int mes, int ano) {
        this.opniao = opniao;
        this.pontuacao = pontuacao;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = new GregorianCalendar (ano, (mes-1), dia);

    }

    @Override
    public String toString() {
        return "Comentario{" +
                "descricao='" + opniao + '\'' +
                ", pontuacao=" + pontuacao +
                ", cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + data +
                '}';
    }
}
