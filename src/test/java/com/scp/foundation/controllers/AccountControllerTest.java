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

import com.scp.foundation.domains.AccountRepository;
import com.scp.foundation.models.Account;

@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:datasets/integration/integration_test_before.sql"}, config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
//@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {  "classpath:datasets/integration/integration_test_after.sql"}, config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
class AccountControllerTest {
	
	private static final String ENDPOINT = "/api/v1/account/accounts";
	
    @Autowired
    private WebApplicationContext context;
    
    private MockMvc mockMvc;

    @Mock
    private AccountRepository accountRepository;
    
    @InjectMocks
    private AccountDto accountDTO;
    
    @BeforeEach
    public void init() throws Exception {
        Account account = new Account();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }
    
    @Test
    void getAccountWhenExists() throws Exception {
    	String username = "test";
    	
        mockMvc .perform(get(new StringBuilder(ENDPOINT)
                .append(username).toString()))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").value(username))
                .andExpect(jsonPath("username").value("test"));
    }
    
    @AfterEach
    public void afterTest() throws Exception {
        SecurityContextHolder.clearContext();
    }
}
