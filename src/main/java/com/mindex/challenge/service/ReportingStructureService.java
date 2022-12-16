package com.mindex.challenge.service;


import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureService {
    //read should be the only method we will need -> will take an employee ID as parameter
    ReportingStructure read(String id);

}
