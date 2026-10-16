package ua.college.library.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.college.library.model.Book;
import ua.college.library.repository.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.save(new Book(null, "Кобзар", "Тарас Шевченко", 1840));
        bookRepository.save(new Book(null, "Cast under an alien sun", "Олан Торенсен", 2016));
        bookRepository.save(new Book(null, "1984", "Джордж Орвелл", 1949));
        bookRepository.save(new Book(null, "Маленький принц", "Антуан де Сент-Екзюпері", 1943));
        bookRepository.save(new Book(null, "Етюд у багряних тонах", "Артур Конан Дойл", 1887));
    }
}
