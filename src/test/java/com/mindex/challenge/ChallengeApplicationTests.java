package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompensationRepository compensationRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void getReportingStructureTest() throws Exception {
		//testing GET request for John Lennon's ReportingStructure result
		mockMvc.perform(MockMvcRequestBuilders
						.get("/reportingstructure/{id}","16a596ae-edd3-4847-99fe-c4518e82c86f")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numberOfReports", is(4)));

	}

	@Test
	public void postCompensationCreateTest() throws Exception{
		//Testing adding a Compensation obj to the repository via POST
		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");

		//Making the Compensation object
		Compensation compensation = new Compensation();
		compensation.setEmployee(employee);
		compensation.setSalary(90000);

		//Bit of a hacky way of sending in the date. I initially tested out my code by sending a POST request with js
		//in the browser's console and everything worked fine. The code takes in a string of a date and converts it to
		//a LocalDate object. But when it came to doing it in Java I was unsure how to do it since turning the Compensation
		//object into a JSON string sends a LocalDate object instead leading to an error. So in these next 2 lines I
		//replace the empty effectiveDate field with a test date to pass to the POST request mimicking what I did in js.
		//Would appreciate some feedback on this.
		String compensationJSON = asJsonString(compensation);
		compensationJSON = compensationJSON.replace("\"effectiveDate\":null","\"effectiveDate\":\"2020-05-01\"");


		mockMvc.perform(MockMvcRequestBuilders
						.post("/compensation")
						.content(compensationJSON)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").exists())
				.andDo(print());

	}

	@Test
	public void getCompensationTest() throws Exception {

		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		//Making the Compensation object
		Compensation compensation = new Compensation();
		compensation.setEmployee(employee);
		compensation.setSalary(90000);
		String compensationJSON = asJsonString(compensation);
		compensationJSON = compensationJSON.replace("\"effectiveDate\":null","\"effectiveDate\":\"2020-05-01\"");
		//first submitting something to the db to find with the GET
		mockMvc.perform(MockMvcRequestBuilders
						.post("/compensation")
						.content(compensationJSON)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").exists());

		mockMvc.perform(MockMvcRequestBuilders
						.get("/compensation/{id}", "16a596ae-edd3-4847-99fe-c4518e82c86f")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.salary",is(90000)))
				.andExpect(jsonPath("$.effectiveDate",is("2020-05-01")));

	}

	//turn object into key value pairs for json string
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
