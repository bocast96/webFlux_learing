package webfux.database;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webfux.model.Employee;

import java.util.UUID;

@Component
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, UUID> {

}
