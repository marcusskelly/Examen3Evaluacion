import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Libro {

    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private int anioPublicacion;
    private int numPaginas;
    private double precio;


    public Libro(String isbn, String autor, String titulo, String editorial, int anioPublicacion, int numPaginas, double precio) {
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", numPaginas=" + numPaginas +
                ", precio=" + precio +
                '}';
    }


    public static Libro crearLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un ISBN");
        String isbn = sc.nextLine();
        System.out.println("Introduce un autor");
        String autor = sc.nextLine();
        System.out.println("Introduce un titulo");
        String titulo = sc.nextLine();
        System.out.println("Introduce una editorial");
        String editorial = sc.nextLine();
        System.out.println("Introduce un a??o de publicacion");
        int anioPublicacion = sc.nextInt();
        System.out.println("Introduce un numero de paginas");
        int numPaginas = sc.nextInt();
        System.out.println("Introduce un precio");
        double precio = sc.nextDouble();
        Libro libro1 = new Libro(isbn,autor,titulo,editorial,anioPublicacion,numPaginas,precio);
        return libro1;
    }


    public static Libro crearLibro(String isbn, String autor, String titulo, String editorial, int anioPublicacion, int numPaginas, double precio) {

        Libro libro1 = new Libro(isbn, autor, titulo, editorial, anioPublicacion, numPaginas, precio);

        return libro1;
    }

    public static void a??adirLibro(Libro libro) {
        String[] campos = libro.getIsbn().split("-");
        File fichero = new File("Editoriales" + "\\" + campos[2] + libro.getEditorial());
        fichero.mkdirs();



        File fichero2 = new File("Editoriales" + "\\" + campos[2] + libro.getEditorial() + "\\" + libro.getIsbn() + ".txt");
       /*
        try {
            fichero2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        try (FileWriter fw = new FileWriter(fichero2, true)) {
            fw.write("\n" + "ISBN" + ":" + libro.getIsbn());
            fw.write("\n" + "Autor/es" + ":" + libro.getAutor());
            fw.write("\n" + "Titulo" + ":" + libro.getTitulo());
            fw.write("\n" + "Editorial" + ":" + libro.getEditorial());
            fw.write("\n" + "Fecha de publicacion" + ":" + libro.getAnioPublicacion());
            fw.write("\n" + "Paginas" + ":" + libro.getNumPaginas());
            fw.write("\n" + "Precio" + ":" + libro.getPrecio() + "$");

        } catch (IOException e) {
            System.out.println("Excepci??n al escribir en el  fichero: " + e.getMessage());
        }

        String ruta2 = "C:\\Users\\admin1\\IdeaProjects\\Examen3Evaluacion\\catalogo.csv";


                    try (FileWriter fw1 = new FileWriter(ruta2, true)) {

                        fw1.write("\n"  + libro.getIsbn() + ";" +libro.getAutor() + ";" +libro.getTitulo() + ";" +libro.getEditorial() + ";" +libro.getAnioPublicacion() + ";" + libro.getNumPaginas() + ";" + libro.getPrecio());

                        } catch (IOException e) {
                        e.printStackTrace();
                    }


    }



}
