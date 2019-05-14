package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.dto.ResultDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrchestrationServiceImplTest {
    private User user;
    private LocalDate date;
    private Payment payment;
    @Mock
    private PaymentServiceImpl paymentService;
    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private OrchestrationServiceImpl orchestrationService;

    @Before
    public void setUp() throws Exception {
        user = new User("Testname", "Test address", "test@test.test");
        date = LocalDate.parse("2018-10-12");
        payment = new Payment("1111222233334444", date, "123", "Test address");
    }

    @Test
    public void proceedCreate() {
        ResultDto resultDto = new ResultDto(payment.transformToDto(), user.transformToDto());
        when(paymentService.save(payment)).thenReturn(payment);
        when(userService.save(user)).thenReturn(user);
        ResultDto resultDto1 = orchestrationService.proceedCreate(user, payment);
        assertEquals(resultDto.getPaymentDto(), resultDto1.getPaymentDto());
        assertEquals(resultDto.getUserDto(), resultDto1.getUserDto());
    }
}