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
    /*

    de esta manera no podia crear libros

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
        System.out.println("Introduce un año de publicacion");
        int anioPublicacion = sc.nextInt();
        System.out.println("Introduce un numero de paginas");
        int numPaginas = sc.nextInt();
        System.out.println("Introduce un precio");
        int precio = sc.nextInt();
        Libro libro1 = new Libro(isbn,autor,titulo,editorial,anioPublicacion,numPaginas,precio);

        return libro1;
    }
*/

    public static Libro crearLibro(String isbn, String autor, String titulo, String editorial, int anioPublicacion, int numPaginas, double precio) {

        Libro libro1 = new Libro(isbn, autor, titulo, editorial, anioPublicacion, numPaginas, precio);

        return libro1;
    }

    public static void añadirLibro(Libro libro) {
        String[] campos = libro.getIsbn().split("-");
        File fichero = new File("Editoriales" + "\\" + campos[2] + libro.getEditorial());
        fichero.mkdirs();


        System.out.println(Arrays.toString(campos));
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
            System.out.println("Excepción al escribir en el  fichero: " + e.getMessage());
        }

        String ruta2 = "C:\\Users\\Estela\\IdeaProjects\\Examen3Evaluacion\\catalago.csv";

        try (FileReader fr = new FileReader(fichero2)) {


            try (BufferedReader br = new BufferedReader(fr)) {
                String línea = br.readLine();
                String[] campos2;
                while (línea != null) {
                    campos2 = línea.split(":");
                    System.out.println(línea);
                    System.out.println(Arrays.toString(campos2));
                    

                    try (FileWriter fw1 = new FileWriter(ruta2, true)) {
                        try (BufferedWriter bw = new BufferedWriter(fw1)) {
                            bw.write(campos2[1] + ";");
                            //[Ljava.lang.String;@1540e19d. Si le pongo campos2, me sale esto
                            // si le pongo campos[1] me sale excepcion indexoutofbounds
                            // si le pongo campos[0] me rellena catalogo con ISBN, Editorial, etc pero solo el titulo.

                        }
                    }
                    línea = br.readLine();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}