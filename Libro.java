public class Libro extends Biblioteca {
  String name;
  int availableCopies;
  int borrowedCopies;

  public Libro() {

  }

  public Libro(String bookName, int availableCopies) {
    this.name = bookName;
    this.availableCopies = availableCopies;
    this.borrowedCopies = 0;
  }

  public String stampaLibro() {
    String stampa = "Nome libro: " + getName() + "; Copie disponibili: " + getAvailableCopies()
        + "; Copie in prestito: "
        + getBorrowedCopies() + ";";
    return stampa;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAvailableCopies() {
    return availableCopies;
  }

  public void setAvailableCopies(int availableCopies) {
    this.availableCopies = availableCopies;
  }

  public int getBorrowedCopies() {
    return borrowedCopies;
  }

  public void setBorrowedCopies(int borrowedCopies) {
    this.borrowedCopies = borrowedCopies;
  }

}
