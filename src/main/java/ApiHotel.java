import java.util.ArrayList;
import java.util.List;

public class ApiHotel {

    private List<Hotel> hoteles = new ArrayList<>();


    public void addHotel(Hotel h) {
        this.hoteles.add(h);
    }

    public List<Hotel> realizarBusqueda(String fechaInicio, String fechaFin, String ciudad) {

        List<Hotel> hotelesEncontrados = new ArrayList<>();

        for (Hotel h: this.hoteles) {
            if (h.hayLugar(fechaInicio, fechaFin) && h.ciudad().equals(ciudad)) {
                hotelesEncontrados.add(h);
            }
        }

        return hotelesEncontrados;
    }
}
