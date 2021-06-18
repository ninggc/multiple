package com.ninggc.esdemo;

import com.ninggc.esdemo.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 90697
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    Employee queryById(String id);
}
