package com.projarq.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.biblioteca.entities.Book;

@RestController
@RequestMapping("/library")
public class Controller {
    private List<Book> books = List.of(
        new Book("O Senhor dos Anéis", "J. R. R. Tolkien", 1954, 1200),
        new Book("Dom Quixote", "Miguel de Cervantes", 1605, 863),
        new Book("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 96),
        new Book("O Hobbit", "J. R. R. Tolkien", 1937, 310),
        new Book("Cem Anos de Solidão", "Gabriel García Márquez", 1967, 417),
        new Book("1984", "George Orwell", 1949, 328),
        new Book("A Revolução dos Bichos", "George Orwell", 1945, 152)
    );

    @GetMapping("")
    @CrossOrigin(origins="*")
    public String welcomeMessage() throws FileNotFoundException {
        File file = new File("src/main/resources/static/index.html");
        Scanner scanner = new Scanner(file);
        String html = "";
        while (scanner.hasNextLine()) {
            html += scanner.nextLine();
        }
        scanner.close();
        return html;
    }

    @GetMapping("books")
    @CrossOrigin(origins="*")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("authors")
    @CrossOrigin(origins="*")
    public List<String> getAuthors() {
        List<String> authors = books.stream()
            .map(book -> book.getAuthor())
            .distinct()
            .toList();
        return authors;
    }

    @GetMapping("titles")
    @CrossOrigin(origins="*")
    public List<String> getTitles() {
        List<String> titles = books.stream()
            .map(book -> book.getAuthor())
            .toList();
        return titles;
    }
}
