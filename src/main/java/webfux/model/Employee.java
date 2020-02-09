package webfux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("EMPLOYEE")
public class Employee {

    public Employee(NewEmployee newEmployee){
        this.id = UUID.randomUUID();
        this.name = newEmployee.getName();
        this.salary = newEmployee.getSalary();
    }

    @Id
    UUID id;
    String name;
    double salary;
}
