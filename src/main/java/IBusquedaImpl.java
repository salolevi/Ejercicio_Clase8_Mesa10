import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class IBusquedaImpl implements IBusqueda {

    private ApiHotel apiHotel;
    private ApiVuelo apiVuelo;

    public IBusquedaImpl(ApiHotel apiHotel, ApiVuelo apiVuelo) {
        this.apiHotel = apiHotel;
        this.apiVuelo = apiVuelo;
    }

    @Override
    public void realizarBusqueda(String fechaInicio, String fechaFin, String origen, String ciudad) {
        List<Vuelo> vuelosEncontrados = apiVuelo.realizarBusqueda(fechaInicio, fechaFin, origen, ciudad);
        List<Hotel> hotelesEncontrados = apiHotel.realizarBusqueda(fechaInicio, fechaFin, ciudad);

        System.out.println("Se han encontrado " + vuelosEncontrados.size() + " vuelos");
        System.out.println("Se han encontrado " + hotelesEncontrados.size() + " hoteles");
    }
}
