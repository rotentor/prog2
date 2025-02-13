public class TestFecha {
    public static void main(String[] args) {
        Fecha ob1, ob2, ob12;
        ob1 = new Fecha(4, 11, 1996);
        ob2 = new Fecha("22/10/2001");
        ob12 = new Fecha(ob1);
        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println(ob12);
    }
}
