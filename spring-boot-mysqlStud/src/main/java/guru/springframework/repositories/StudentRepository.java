package guru.springframework.repositories;

import guru.springframework.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}