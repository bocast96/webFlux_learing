package webfux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webfux.database.EmployeeRepository;
import webfux.model.Employee;
import webfux.model.NewEmployee;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.BaseStream;

@RestController
@RequestMapping("/employee")
public class controller {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Mono<Employee> insert(@RequestBody NewEmployee newEmployee) {
        Employee employee = new Employee(newEmployee);

        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployee(@PathVariable("id")UUID id) {
        return repository.findById(id);
    }

    private Mono<String> getSchema() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("schema.sql").toURI());
        return Flux
                .using(() -> Files.lines(path), Flux::fromStream, BaseStream::close)
                .reduce((line1, line2) -> line1 + "\n" + line2);
    }

}
