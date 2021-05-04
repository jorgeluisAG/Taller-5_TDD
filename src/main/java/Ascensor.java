public class Ascensor {

    private Character[] pisoDeEdificio = {'0', '0', '0'};
    private String ultimaDireccion = "subir";
    private String estadoPuertaAscensor = "cerrado";
    private final int limite_sup = 3;
    private final int limite_inf = 1;
    private final int limite_max_persona = 1;

    public String usoAscensor(int personas, int lugarpersona, int pisoActualAscensor, int pisoDestinoAscensor) throws Exception {

        verificarPersonas(personas);
        verificarPiso(pisoDestinoAscensor);
        int posPersona = crearPersona();
        estadoPosicionPersona(posPersona);
        estadoPisoAsensor();
        ultimaDireccion = funcionamientoAscensor();
        if (llamarAscensor(lugarpersona, pisoDestinoAscensor)) {
            //ultimaDireccion = funcionamientoAscensor();
            return "Se puede ir al piso destino que la persona quiere ir";
        }
        return "No se puede ir al piso destino que la persona quiere ir";
    }

    public int crearPersona() {
        int posicionPersona = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
        return posicionPersona;
    }

    public void verificarPersonas(int personas) throws Exception {
        if (personas > limite_max_persona) {
            throw new Exception();
        }
    }

    public void verificarPiso(int piso) throws Exception {
        if (piso < limite_inf || piso > limite_sup) {
            throw new Exception();
        }
    }

    public void estadoPisoAsensor() {
        for (int i = 0; i < pisoDeEdificio.length; i++) {
            pisoDeEdificio[i] = 0;
        }
    }

    public String estadoPosicionPersona(int posicionPersona) {
        pisoDeEdificio[posicionPersona - 1] = '1';
        return "" + posicionPersona + "";
    }

    public String funcionamientoAscensor(){
        if(ultimaDireccion == "bajar"){
            return "subir";
        }
        return "bajar";
    }

    private boolean llamarAscensor(int lugPersona, int destino) {
        if (lugPersona != destino) {
            return true;
        }
        return false;
    }

}