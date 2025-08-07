package org.example.spring.book.controller;

import com.example.demo.book.model.BookDto;
import com.example.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody BookDto.Register dto) {
        bookService.register(dto);

        return ResponseEntity.status(200).body("등록 성공");
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<BookDto.BookRes> response = bookService.list();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/read")
    public ResponseEntity read(Integer idx) {
        BookDto.BookRes response = bookService.read(idx);

        return ResponseEntity.status(200).body(response);
    }


    @GetMapping("/search")
    public ResponseEntity search(String name) {
        List<BookDto.BookRes> response = bookService.search(name);

        return ResponseEntity.status(200).body(response);
    }


}
