import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
  ArrayList<Libro> books = new ArrayList<Libro>();// Books
  // Come creo il counter relativo a ogni singolo libro?
  Scanner sc = new Scanner(System.in);
  int counterBorrowed;
  int counterAvailable;

  /*
   * Metodo precedente
   * public void prestaLibro(String nomeLibro) {
   * // User can take a copy of the book, decreasing the number of copies
   * available
   * // but increasing the one of the borrowed ones.
   * // If copies aren't available, throw an error
   * System.out.println("Scegli un libro");
   * String nomeLibroInPrestito = sc.nextLine();
   * boolean flag = true; // lo lascio true finchè non
   * for (int i = 0; i < books.size(); i++) {
   * // se il nome del libro corrisponde a uno di quelli iterati
   * if (nomeLibroInPrestito.equalsIgnoreCase(books.get(i).getName())) {
   * // e se le copie disponibili sono > 0
   * if (books.get(i).getAvailableCopies() > 0) {
   * // Dichiaro counterBorrowed = alle copie già prestate (0 default) + 1
   * counterBorrowed = books.get(i).getBorrowedCopies() + 1;
   * // Dichiaro counterAvailable = alle copie già disponibili - 1
   * counterAvailable = books.get(i).getAvailableCopies() - 1;
   * // Uso i set per settare i nuovi valori
   * books.get(i).setBorrowedCopies(counterBorrowed);
   * books.get(i).setAvailableCopies(counterAvailable);
   * } else {
   * System.out.println("Non ci sono copie disponinili per il libro " +
   * books.get(i).getName());
   * }
   * } else {
   * System.out.println("Il libro inserito non è presente nella nostra Biblioteca"
   * );
   * }
   * }
   * }
   */
  // Metodo successivo basato su questo commentato sopra, da finire
  public void prestaLibro(String nomeLibroInPrestito) {
    int counterLibriPrestito = 0;
    int counterLibriDisponibili = 0;
    boolean flagPerCopieDisponibili = true;
    boolean flagPerLibroPresente = true;
    for (int i = 0; i < books.size(); i++) {
      if (nomeLibroInPrestito.equalsIgnoreCase(books.get(i).getNome())) {
        flagPerLibroPresente = false;
        if (books.get(i).getAvailableCopies() > 0) {
          counterLibriPrestito = books.get(i).getBorrowedCopies();
          counterLibriPrestito++;
          books.get(i).setBorrowedCopies(i);(counterLibriPrestito);
          counterLibriDisponibili = books.get(i).getAvailableCopies();
          counterLibriDisponibili--;
          books.get(i).setAvailableCopies(i);(counterLibriDisponibili);
          flagPerCopieDisponibili = false;
        }
      }
    }
    if (flagPerLibroPresente) {
      System.out.println("libro non presente");
    }
    if (flagPerCopieDisponibili) {
      System.out.println("copie non disponibili");
    }
  }
  /*
   * public Libro trovaPerNome(String nome) {
   * for (Libro libro : books) {
   * if (libro.name == nome) {
   * return libro;
   * }
   * }
   * return null;
   * }
   */

  public void restituisciLibro() {
    // User gives back the copy of the book, increasing the number of available
    // copies and decreasing the number of borrowed ones.
    // If user tries to give back a copy that he didn't borrow, throw error
    // How can I throw error if prestaLibro isn't casted before?

  }

  public void aggiungiLibro(Libro libro) {
    // user can add a new book to the list, with the number of book copies
    books.add(libro);
  }

  public void rimuoviLibro(Libro libro) {
    books.remove(libro);

  }

  public static void main(String[] args) {
    Biblioteca bookstore = new Biblioteca();
    Libro libri = new Libro();
    Libro libro1 = new Libro("The Labyrinth of Spirits", 3);
    Libro libro2 = new Libro("The Shadow of the wind", 2);
    Libro libro3 = new Libro("The Angel's game", 1);

    bookstore.aggiungiLibro(libro1);
    bookstore.aggiungiLibro(libro2);
    bookstore.aggiungiLibro(libro3);

    System.out.println("Benvenuto nella Biblioteca! Questi sono i libri disponibili:");
    for (Libro libro : bookstore.books) {
      System.out.println(libro.stampaLibro());
    }
    /*
     * Per ciclare anche gli indici, ma non so come usare stampaLibro();
     * for (int i = 0; i < bookstore.books.size(); i++) {
     * System.out.println("[" + (i + 1) + "]" + bookstore.books.getName(i));
     * }
     */
    System.out
        .println("Cosa vuoi fare?\n1)Aggiungere un libro\n2)Prendere in prestito un libro\n3)Restituire un libro");
    Scanner sc = new Scanner(System.in);
    String libroDaPrestare = sc.nextLine();
    bookstore.prestaLibro(libroDaPrestare);
  }
}
