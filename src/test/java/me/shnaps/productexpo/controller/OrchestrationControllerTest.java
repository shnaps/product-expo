package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.ResultDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.service.OrchestrationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(OrchestrationController.class)
public class OrchestrationControllerTest {

    private User user;
    private LocalDate date;
    private Payment payment;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrchestrationService orchestrationService;

    private OrchestrationController controller;

    @Before
    public void setUp() throws Exception {
        user = new User("Testname", "Test address", "test@test.test");
        date = LocalDate.parse("2018-10-12");
        payment = new Payment("1111222233334444", date, "123", "Test address");
    }

    @Test
    public void proceedCreation() {
        ResultDto resultDto = new ResultDto(payment.transformToDto(), user.transformToDto());
        when(orchestrationService.proceedCreate(Mockito.any(), Mockito.any())).thenReturn(resultDto);
        RequestBuilder builder = MockMvcRequestBuilders.get("/proceed").accept(MediaType.APPLICATION_JSON);
        try {
            MvcResult mvcResult = mockMvc.perform(builder).andReturn();
            String expectedResult = "{\"paymentDto\":{\"cardNumber\":\"1111222233334444\",\"expireDate\":\"2018-10-12\",\"cvv\":\"123\",\"paymentAddress\":\"Test address\"},\"userDto\":{\"name\":\"Testname\",\"address\":\"Test address\",\"email\":\"test@test.test\"}}";
            String contentAsString = mvcResult.getResponse().getContentAsString();
            JSONAssert.assertEquals(expectedResult, contentAsString, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}