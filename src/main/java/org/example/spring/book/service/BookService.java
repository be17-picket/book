package org.example.spring.book.service;

import com.example.demo.b.model.BDto;
import com.example.demo.b.repository.BRepository;
import com.example.demo.book.model.Book;
import com.example.demo.book.model.BookDto;
import com.example.demo.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public void register(BookDto.Register dto) {
        Book book = bookRepository.save(dto.toEntity());

        for(ReviewDto.Register reviewDto : dto.getReview()){
            reviewRepository.save(reviewDto.toEntity(book));
        }
    }

    public List<BookDto.BookRes> list() {
        List<Book> result = bookRepository.findAll();

        return result.stream().map(BookDto.BookRes::from).toList();
    }

    public BookDto.BookRes read(Integer idx) {
        Optional<Book> result = bookRepository.findById(idx);

        if (result.isPresent()) {
            Book entity = result.get();

            return BookDto.BookRes.from(entity);
        }

        return null;
    }

    public List<BookDto.BookRes> search(String title) {
        List<Book> result = bookRepository.findByTitle(title);

        return result.stream().map(BookDto.BookRes::from).toList();
    }
}
