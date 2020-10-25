package com.example.LibraryAppDemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book",uniqueConstraints = @UniqueConstraint(columnNames = {"isbn"}))

public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name", unique=true)
    @NotNull
    private String name;

    @Column(name = "alt_name")
    @NotNull
    private String altName;

    @Column(name = "serial_name", unique = true)
    @NotNull
    private String bookSerialName;

    @Column(name = "isbn", unique = true)
    @NotNull
    private String isbn;

    @Column(name = "description")
    @NotNull
    private String description;


    @ManyToOne(optional = false)
    private Publisher publisher;

    @ManyToOne(optional = false)
    private Author author;



    public String getName() {
        return name;
    }

    public String getAltName() {
        return altName;
    }

    public String getBookSerialName() {
        return bookSerialName;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public void setBookSerialName(String bookSerialName) {
        this.bookSerialName = bookSerialName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", altName='" + altName + '\'' +
                ", bookSerialName='" + bookSerialName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                getName().equals(book.getName()) &&
                getAltName().equals(book.getAltName()) &&
                getBookSerialName().equals(book.getBookSerialName()) &&
                getIsbn().equals(book.getIsbn()) &&
                getDescription().equals(book.getDescription()) &&
                getPublisher().equals(book.getPublisher()) &&
                getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getAltName(), getBookSerialName(), getIsbn(), getDescription(), getPublisher(), getAuthor());
    }
}
