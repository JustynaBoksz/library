# System Zarządzania Książkami

Specyfikacja funkcjonalna:

- Wyszukiwanie książek według różnych kryteriów (tytuł, autor, rok wydania, gatunek).
- Dodawanie nowych książek do kolekcji.
- Edytowanie istniejących książek.
- Usuwanie książek z kolekcji.
- Wyświetlanie informacji o książkach.

Aplikacja korzysta z PostgreSQL jako bazy danych do przechowywania informacji o książkach.

# Wymagania

Przed uruchomieniem projektu upewnij się, że masz zainstalowane następujące oprogramowanie:

- JDK (rekomendowane JDK 21)
- JavaFX SDK
- PostgreSQL
- IDE wspierające JavaFX (np. IntelliJ IDEA, Eclipse)

## Konfiguracja bazy danych

Pobierz i zainstaluj PostgreSQL. Utwórz bazę danych o nazwie `book_management`.

Wykonaj skrypt DDL.

```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    genre VARCHAR(255) NOT NULL
);
```

Wstaw przykładowe dane przy pomocy drugiego skryptu.

```sql
INSERT INTO books (title, author, year, genre) VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 'Fiction'),
    ('To Kill a Mockingbird', 'Harper Lee', 1960, 'Fiction'),
    ('1984', 'George Orwell', 1949, 'Dystopian'),
    ('Pride and Prejudice', 'Jane Austen', 1813, 'Romance'),
    ('The Catcher in the Rye', 'J.D. Salinger', 1951, 'Fiction'),
    ('The Hobbit', 'J.R.R. Tolkien', 1937, 'Fantasy'),
    ('Fahrenheit 451', 'Ray Bradbury', 1953, 'Dystopian'),
    ('Moby Dick', 'Herman Melville', 1851, 'Adventure'),
    ('War and Peace', 'Leo Tolstoy', 1869, 'Historical'),
    ('Crime and Punishment', 'Fyodor Dostoevsky', 1866, 'Crime'),
    ('The Odyssey', 'Homer', -800, 'Epic'),
    ('Great Expectations', 'Charles Dickens', 1861, 'Fiction'),
    ('Ulysses', 'James Joyce', 1922, 'Modernist'),
    ('The Divine Comedy', 'Dante Alighieri', 1320, 'Epic'),
    ('Hamlet', 'William Shakespeare', 1603, 'Tragedy'),
    ('The Brothers Karamazov', 'Fyodor Dostoevsky', 1880, 'Philosophical'),
    ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 1967, 'Magic Realism'),
    ('The Iliad', 'Homer', -750, 'Epic'),
    ('Brave New World', 'Aldous Huxley', 1932, 'Dystopian'),
    ('The Count of Monte Cristo', 'Alexandre Dumas', 1844, 'Adventure'),
    ('Les Misérables', 'Victor Hugo', 1862, 'Historical'),
    ('Anna Karenina', 'Leo Tolstoy', 1877, 'Romance'),
    ('The Sound and the Fury', 'William Faulkner', 1929, 'Fiction'),
    ('In Search of Lost Time', 'Marcel Proust', 1913, 'Modernist'),
    ('Don Quixote', 'Miguel de Cervantes', 1615, 'Adventure');
```

## Konfiguracja Projektu

Sklonuj repozytorium:

```shell
git clone https://github.com/yourusername/book-management-system.git
cd book-management-system
```

Skonfiguruj połączenie z bazą danych. Otwórz plik `BookDAO.java` i zaktualizuj szczegóły połączenia z bazą danych:

```java
public BookDAO() {
    try {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/book_management",
            "yourusername",
            "yourpassword"
            );
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

Zbuduj i uruchom projekt.
