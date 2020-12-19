import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Take_Away extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;

    public Take_Away(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora) {
        super(cliente, restaurante, data, hora);
        this.listaPratos = listaPratos;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }


    @Override
    public String toString() {
        return super.toString() + "Take_Away{" +
                "listaPratos=" + listaPratos +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
