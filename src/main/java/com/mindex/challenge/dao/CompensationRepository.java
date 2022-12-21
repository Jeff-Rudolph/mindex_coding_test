package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompensationRepository extends MongoRepository<Compensation, Employee> {
    //declare query method on interface
    //Spring splits the words after findBy until it finds a match for something that makes sense
    //We are looking for compensation.Employee.employeeID so this should do the trick
    Compensation findByEmployeeEmployeeId(String employeeID);
}
