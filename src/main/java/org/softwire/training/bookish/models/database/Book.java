package org.softwire.training.bookish.models.database;

import java.beans.ConstructorProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Book {
    @ConstructorProperties({"isbn", "title", "author"})
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    private String isbn;
    private String title;
    private String author;
}
