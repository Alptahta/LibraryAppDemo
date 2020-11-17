package com.example.LibraryAppDemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book",uniqueConstraints = @UniqueConstraint(columnNames = {"isbn"}))

public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique=true)
    @NotNull
    private String name;

    @Column(name = "alt_name")
    @NotNull
    private String altName;

    @Column(name = "serial_name")
    @NotNull
    private String serialName;

    @Column(name = "isbn", unique = true)
    @NotNull
    private String isbn;

    @Column(name = "description")
    @NotNull
    private String description;


    @ManyToOne(optional = false)
    @NotNull
    private Publisher publisher;

    @ManyToOne(optional = false)
    @NotNull
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId().equals(book.getId()) &&
                getName().equals(book.getName()) &&
                getAltName().equals(book.getAltName()) &&
                getSerialName().equals(book.getSerialName()) &&
                getIsbn().equals(book.getIsbn()) &&
                getDescription().equals(book.getDescription()) &&
                getPublisher().equals(book.getPublisher()) &&
                getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAltName(), getSerialName(), getIsbn(), getDescription(), getPublisher(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", altName='" + altName + '\'' +
                ", serialName='" + serialName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }
}
