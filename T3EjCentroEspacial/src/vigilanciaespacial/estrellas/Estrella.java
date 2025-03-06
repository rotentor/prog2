package vigilanciaespacial.estrellas;

public class Estrella {
    private final String identificador;
    private double campoMagnetico;
    private long indiceColor;

    public Estrella(String identificador, double campoMagnetico, long indiceColor) {
        this.identificador = identificador;
        this.campoMagnetico = campoMagnetico;
        this.indiceColor = indiceColor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCampoMagnetico() {
        return campoMagnetico;
    }

    public long getIndiceColor() {
        return indiceColor;
    }

    public void desplazar() {
        campoMagnetico = campoMagnetico-5.5;
        indiceColor = indiceColor-1;
    }

    public boolean esIgual(Estrella estrella) {
        return this.identificador.equals(estrella.getIdentificador());
    }
}