import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BusquedaTest {

    @Test
    public void test1() {
//      GIVEN
        Vuelo vuelo1 = new Vuelo("9/12/18", "9/01/19", "Buenos Aires", "Barcelona", true);
        Vuelo vuelo2 = new Vuelo("14/12/18", "14/01/19", "Montevideo", "Buenos Aires", true);
        Vuelo vuelo3 = new Vuelo("9/12/18", "9/01/19", "Buenos Aires", "Barcelona", true);

        ApiVuelo apiVuelo = mock(ApiVuelo.class);
        apiVuelo.addVuelo(vuelo1);
        apiVuelo.addVuelo(vuelo2);
        apiVuelo.addVuelo(vuelo3);

        Hotel hotel1 = new Hotel(5, "Barcelona", "Avenida Figueroa Alcorta 3151");
        Hotel hotel2 = new Hotel(1, "Lima", "Av. Peru 6969");
        Hotel hotel3 = new Hotel(4, "Barcelona", "Avenida Figueroa Alcorta 3151");

        ApiHotel apiHotel = mock(ApiHotel.class);
        apiHotel.addHotel(hotel1);
        apiHotel.addHotel(hotel2);
        apiHotel.addHotel(hotel3);

        IBusquedaImpl servicioBusqueda = new IBusquedaImpl(apiHotel, apiVuelo);

//      WHEN
        servicioBusqueda.realizarBusqueda("9/12/18", "9/01/19", "Buenos Aires", "Barcelona");
//      THEN
        verify(apiHotel).realizarBusqueda("9/12/18", "9/01/19", "Barcelona");
        verify(apiVuelo).realizarBusqueda("Buenos Aires", "Barcelona", "9/12/18", "9/01/19");

    }
}
