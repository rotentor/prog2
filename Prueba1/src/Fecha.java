public class Fecha {
    private int day, month, year;
    public Fecha(String date) {
        String [] partes = date.split("/");
        day = Integer.parseInt(partes[0]);
        month = Integer.parseInt(partes[1]);
        year = Integer.parseInt(partes[2]);
    }
    public Fecha(int dia, int mes, int anio) {
        day = dia;
        month = mes;
        year = anio;
    }
    public Fecha(Fecha obj) {
        this.day = obj.day;
        this.month = obj.month;
        this.year = obj.year;
    }
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}