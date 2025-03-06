package vigilanciaespacial;

import vigilanciaespacial.estrellas.Estrella;

public class SateliteArtificial {
    private static int contador = 0;
    private final String identificador;
    private Estrella estrellaMonitorizada;

    public SateliteArtificial(Estrella estrella) {
        estrellaMonitorizada = estrella;
        identificador = "Sat" + (contador+1);
        contador++;
    }

    public double darTemperatura() {
        return estrellaMonitorizada.getIndiceColor() * 2.1;
    }

    public boolean hayAlertaTormentaMagnetica() {
        return estrellaMonitorizada.getCampoMagnetico() >= 1000;
    }

    public boolean esIgual(SateliteArtificial satelite) {
        return estrellaMonitorizada.esIgual(satelite.getEstrella());
    }

    public String toString() {
        String info = estrellaMonitorizada.getIdentificador()+" ("+darTemperatura()+")";
        if (hayAlertaTormentaMagnetica()) info += " ALERTA!";
        return info;
    }

    //Getters
    public String getIdentificador() {
        return identificador;
    }

    public Estrella getEstrella() {
        return estrellaMonitorizada;
    }

    //Setters
    public void setEstrella(Estrella estrella) {
        estrellaMonitorizada = estrella;
    }
}