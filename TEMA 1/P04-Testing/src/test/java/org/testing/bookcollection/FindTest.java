package org.testing.bookcollection;

import org.junit.jupiter.api.Test;

import org.testing.entidades.BookCollection;
import org.testing.entidades.Book;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindTest {

    BookCollection books = new BookCollection(new ArrayList<>());

    @Test
    public void shouldFindABookByIsbn()
    {
        final String isbnToLocate = "un-isbn-2";
        BookCollection books = new BookCollection(List.of(new Book[]{
                new Book("un-isbn-1", "un titulo 1", "un autor 1", 100),
                new Book(isbnToLocate, "un titulo 2", "un autor 2", 200),
                new Book("un-isbn-3", "un titulo 3", "un autor 3", 300),
        }));
        books.find(isbnToLocate).forEach((Book book) -> assertEquals(isbnToLocate, book.isbn()));
    }

    @Test
    public void shouldNotFindIfCollectionIsEmpty(){
        assertTrue(books.find("1234").isEmpty());
    }

    @Test
    public void shouldGetAnEmptyListIfNoMatchesAreFound() {
        final String isbnToLocate = "un-isbn-6";
        BookCollection books = new BookCollection(List.of(new Book[]{
                new Book("un-isbn-1", "un titulo 1", "un autor 1", 100),
                new Book("un-isbn-2", "un titulo 2", "un autor 2", 200),
                new Book("un-isbn-3", "un titulo 3", "un autor 3", 300),
        }));

        assertTrue(books.find(isbnToLocate).isEmpty());
    }

    @Test
    public void shouldGetExceptionWhenUsingFindOrFailWithAnEmptyCollection(){

            assertThrows(Exception.class, () -> books.findOrFail(" isbn "));
    }

}
