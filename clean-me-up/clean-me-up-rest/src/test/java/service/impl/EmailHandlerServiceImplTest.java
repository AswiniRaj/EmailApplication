package com.effcode.clean.me.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmailHandlerServiceImplTest.class)
@WithMockUser
public class EmailHandlerServiceImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmailHandlerService emailHandlerService;

	EmailDetails emailDetails = new EmailDetails();
	
	@Test
	public void emailServiceTest() throws Exception {
		Mockito.when(emailHandlerService.sendMail(Mockito.anyString(),
						Mockito.anyString())).thenReturn(emailDetails);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/sendEmailApi").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(result.getResponse()
				.getContentAsString(), false);
	}
}