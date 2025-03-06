package vigilanciaespacial;

public class CentroEspacial {
    private String identificador;
    private SateliteArtificial[] satelitesSupervisados;

    public CentroEspacial(String identificador, SateliteArtificial[] satelitesSupervisados) {
        this.identificador = identificador;
        this.satelitesSupervisados = satelitesSupervisados;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String informacionEstrellas() {
        String info = "";
        for (int i=0; i< satelitesSupervisados.length; i++) {
            info += satelitesSupervisados[i] + "\n"; //Se espera salto línea también en última
        }
        return info;
    }

    public boolean comprobarSatelites() {
        boolean resultado = true;
        for (int j = 0; j<satelitesSupervisados.length && resultado; j++) {
            for (int k=j+1; k<satelitesSupervisados.length && resultado; k++) {
                if(satelitesSupervisados[j].esIgual(satelitesSupervisados[k])) {
                    resultado = false;
                }
            }
        }
        if (satelitesSupervisados.length == 0) resultado = false;
        return resultado;
    }
}
