import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;
    private ArrayList<Usuario> reservas;
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
        this.reservas = new ArrayList<>();
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
    public boolean isDisponible(boolean disponible) {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;

    }

    public ArrayList<Usuario> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return  titulo;
    }
}
