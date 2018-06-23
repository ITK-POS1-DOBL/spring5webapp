package org.doblander.lab.spring5webapp.bootstrap;

import org.doblander.lab.spring5webapp.model.Author;
import org.doblander.lab.spring5webapp.model.Book;
import org.doblander.lab.spring5webapp.model.Publisher;
import org.doblander.lab.spring5webapp.repositories.AuthorRepository;
import org.doblander.lab.spring5webapp.repositories.BookRepository;
import org.doblander.lab.spring5webapp.repositories.PublisherRepository;
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

    private void initData(){

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Some Street 5");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        //ddd.setPublisher(harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Another Street 9");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        //noEJB.setPublisher(worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
