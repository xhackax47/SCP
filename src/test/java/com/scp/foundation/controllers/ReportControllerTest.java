package com.scp.foundation.controllers;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.scp.foundation.controllers.report.ReportDto;
import com.scp.foundation.domains.report.ReportRepository;
import com.scp.foundation.models.report.Report;

@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
//		"classpath:datasets/integration/integration_test_before.sql" }, config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
//@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {
//		"classpath:datasets/integration/integration_test_after.sql" }, config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
class ReportControllerTest {

	private static final String ENDPOINT = "/reports";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Mock
	private ReportRepository reportRepository;

	@InjectMocks
	private ReportDto reporttDTO;

	@BeforeEach
	public void init() throws Exception {
		// Report report = new Report();
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

//	@Test
//	void getAccountWhenExists() throws Exception {
//		String name = "test";
//
//		mockMvc.perform(get(new StringBuilder(ENDPOINT).append(name).toString()))
//
//				.andExpect(status().isOk()).andExpect(jsonPath("username").value(name))
//				.andExpect(jsonPath("username").value("test"));
//	}

	@AfterEach
	public void afterTest() throws Exception {
		SecurityContextHolder.clearContext();
	}
}
