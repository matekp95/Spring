package learn.springframework.spring5webapp.bootstrap;

import learn.springframework.spring5webapp.model.Author;
import learn.springframework.spring5webapp.model.Book;
import learn.springframework.spring5webapp.model.Publisher;
import learn.springframework.spring5webapp.repositories.AuthorRepository;
import learn.springframework.spring5webapp.repositories.BookRepository;
import learn.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher1 = new Publisher();
        publisher1.setName("foo");
        publisher1.setAddress("Nieledwia");

        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("faa");
        publisher2.setAddress("Milowka");

        publisherRepository.save(publisher2);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev", "2344", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
