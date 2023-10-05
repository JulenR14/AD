package org.testing.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public record BookCollection(List<Book> books) {
    public List<Book> find(String textToFind) {
        List<Book> foundBooks = new ArrayList<>();
        if (!books.isEmpty()) {
            for (Book book : this.books) {
                if (book.isbn().equals(textToFind) ||
                        book.title().contains(textToFind) ||
                        book.author().contains(textToFind)) {
                    foundBooks.add(book);
                }
            }
        }
        return foundBooks;
    }

    public List<Book> findOrFail(String isbn) throws NoSuchElementException {

        List<Book> foundBooks = new ArrayList<>();

        if(books.isEmpty()){
            throw new NoSuchElementException("No hay nada");
        }

        foundBooks = books.stream().filter(b -> b.isbn().equals(isbn)).toList();

        if(foundBooks.isEmpty()){
            throw new NoSuchElementException("No hay nada");
        }

        return foundBooks;
    }
}
