import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AscensorTest {
    private Ascensor ascensor;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before(){
        //Preparacion de la prueba
        ascensor = new Ascensor();
    }

    @Test
    public void cuandoLaPersonaExeceLaCapacidadLanzarExcepcion() throws Exception{
        //logica de la prueba

        //Verificacion o Assert
        ascensor.usoAscensor(1,1,1,2);
        exception.expect(Exception.class);
        ascensor.usoAscensor(2,1,1,2);
    }
    @Test
    public void cuandoElPisoDestinoNoExisteLanzarExcepcion() throws Exception{
        //logica de la prueba

        //Verificacion o Assert
        exception.expect(Exception.class);
        ascensor.usoAscensor(1,1,1,5);
    }
    @Test
    public void cuandoLaPersonaSeEncuentraEnUnPisoEspecifico(){
        //logica de la prueba

        //Verificacion o Assert
        assertEquals("1",ascensor.estadoPosicionPersona(1));
    }

    @Test
    public void cuandoLaPersonaUtilizaElAscensor() throws Exception{
        //logica de la prueba

        //Verificacion o Assert
        ascensor.usoAscensor(1,1,1,2);
        assertEquals("subir",ascensor.funcionamientoAscensor());

        ascensor.usoAscensor(1,2,2,1);
        assertEquals("bajar",ascensor.funcionamientoAscensor());
    }

    @Test
    public void cuandoLaPersonaQuiereIrASuPisoDestino() throws Exception{
        //logica de la prueba
        String resultado1 = ascensor.usoAscensor(1,1,1,2);
        String resultado2 = ascensor.usoAscensor(1,1,1,1);
        //Verificacion o Assert
        assertEquals("Se puede ir al piso destino que la persona quiere ir",resultado1);
        assertEquals("No se puede ir al piso destino que la persona quiere ir",resultado2);
    }

}
