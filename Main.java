public class Main {

    public static void main(String[] args) {

        Libro libro1 = Libro.crearLibro("978-84-9964-700-5", "Lozano Ortega, Miguel Ángel", " Desarrollo de aplicaciones Android con Java", " Ra-Ma S.A.", 2017, 434, 28.75);
        Libro libro2 = Libro.crearLibro("978-84-267-2841-8", "Sznajdleder, Pablo Augusto", " El gran libro de Java a fondo ", " Marcombo", 2020, 342, 22.88);
        Libro libro3 = Libro.crearLibro("978-84-9964-723-4", "Vázquez Cuesta, Borja", " Java y C++ : paso a paso ", " Ra-Ma S.A.", 2017, 254, 19.13);
        Libro libro4 = Libro.crearLibro("978-84-9164-061-5", "Bowden, Oliver", "Unity ", " La Esfera de los Libros, S.L", 2017, 488, 8.65);
        Libro libro5 = Libro.crearLibro("978-84-267-2682-7", "Lidón, Marc", "Unity 3D ", " Marcombo", 2018, 558, 34.42);


        Libro.añadirLibro(libro1);
        Libro.añadirLibro(libro2);
        Libro.añadirLibro(libro3);
        Libro.añadirLibro(libro4);
        Libro.añadirLibro(libro5);


    }
}
