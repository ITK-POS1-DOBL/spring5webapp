package org.doblander.lab.spring5webapp.repositories;

import org.doblander.lab.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
