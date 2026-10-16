package ua.college.library.repository;

import org.springframework.stereotype.Repository;
import ua.college.library.model.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private final Map<Long, Book> storage = new ConcurrentHashMap<Long, Book>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public Optional<Book> findById(Long id) {
        if (storage.containsKey(id)) {
            return Optional.ofNullable(storage.get(id));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public List<Book> findAll() {
        return storage.values().stream()
                .sorted(Comparator.comparing(Book::getId))
                .toList();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idGenerator.incrementAndGet());
        }
        storage.put(book.getId(), book);
        return book;
    }

}
