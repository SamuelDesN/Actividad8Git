import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Usuario usuario1 = new Usuario("Juan", "Perez", "123456789", "juan@example.com");
        Usuario usuario2 = new Usuario("Maria", "Gomez", "987654321", "maria@example.com");
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        Libro libro1 = new Libro("Java", "Usuario", "0000");
        Libro libro2 = new Libro("Python", "Jane Smith", "1111");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Informacion usuario");
            System.out.println("2. Ver libros disponibles");
            System.out.println("3. Ver libros pendientes de devolver");
            System.out.println("4. Pedir un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Lista de usuarios:");
                    for (Usuario usuario : biblioteca.getUsuarios()) {
                        System.out.println(usuario.getNombre() + " " + usuario.getApellido());
                    }

                    System.out.print("Nombre del usuario: ");
                    String nombreUsuarioBuscar = scanner.next();

                    for (Usuario usuario : biblioteca.getUsuarios()) {
                        if (usuario.getNombre().equals(nombreUsuarioBuscar)) {
                            System.out.println("Información del usuario:");
                            System.out.println("Nombre: " + usuario.getNombre());
                            System.out.println("Apellido: " + usuario.getApellido());
                            System.out.println("Teléfono: " + usuario.getTelefono());
                            System.out.println("Email: " + usuario.getEmail());
                            break;
                        }
                        else {
                            System.out.println("El usuario no fue encontrado");
                            break;
                        }
                    }
                    break;
                case 2:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.next();
                    List<Usuario> usuarios = biblioteca.getUsuarios();
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNombre().equals(nombreUsuario)) {
                            biblioteca.mostrarLibrosPendientes(usuario);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPedir = scanner.next();
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibro = scanner.next();
                    List<Usuario> usuariosPedir = biblioteca.getUsuarios();
                    for (Usuario usuario : usuariosPedir) {
                        if (usuario.getNombre().equals(nombreUsuarioPedir)) {
                            List<Libro> libros = biblioteca.getLibros();
                            for (Libro libro : libros) {
                                if (libro.getTitulo().equals(tituloLibro)) {
                                    biblioteca.pedirLibro(usuario, libro);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioDevolver = scanner.next();
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibroDevolver = scanner.next();
                    List<Usuario> usuariosDevolver = biblioteca.getUsuarios();
                    for (Usuario usuario : usuariosDevolver) {
                        if (usuario.getNombre().equals(nombreUsuarioDevolver)) {
                            List<Libro> librosPendientes = usuario.getLibrosPendientes();
                            for (Libro libro : librosPendientes) {
                                if (libro.getTitulo().equals(tituloLibroDevolver)) {
                                    biblioteca.devolverLibro(usuario, libro);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

    }
}
