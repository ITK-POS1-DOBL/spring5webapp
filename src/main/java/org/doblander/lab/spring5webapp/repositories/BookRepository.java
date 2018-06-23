package org.doblander.lab.spring5webapp.repositories;

import org.doblander.lab.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
