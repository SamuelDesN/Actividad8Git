import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
    }
    private boolean disponible;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn());
        }
    }

    public void mostrarLibrosPendientes(Usuario usuario) {
        System.out.println("Libros pendientes de devolucion para " + usuario.getNombre() + ":");
        for (Libro libro : usuario.getLibrosPendientes()) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn());
        }
    }

    public void pedirLibro(Usuario usuario, Libro libro) {
        usuario.agregarLibroPendiente(libro);
        System.out.println(usuario.getNombre() + " ha pedido el libro " + libro.getTitulo());
    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        usuario.devolverLibro(libro);
        System.out.println(usuario.getNombre() + " ha devuelto el libro " + libro.getTitulo());
    }
    public void reservarLibro(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
        }
        libro.agregarReserva(usuario);
        System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido reservado por " + usuario.getNombre());
    }
}
