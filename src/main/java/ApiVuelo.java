import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {
    private List<Vuelo> vuelos = new ArrayList<>();


    public void addVuelo(Vuelo v) {
        this.vuelos.add(v);
    }

    public List<Vuelo> realizarBusqueda(String origen, String destino, String fechaInicio, String fechaFin) {

        List<Vuelo> vuelosEncontrados = new ArrayList<>();

        for (Vuelo v: this.vuelos) {
            if (v.origen().equals(origen) && v.destino().equals(destino) && v.fechaInicio().equals(fechaInicio) && v.fechaFin().equals(fechaFin)) {
                vuelosEncontrados.add(v);
            }
        }

        return vuelosEncontrados;
    }
}
