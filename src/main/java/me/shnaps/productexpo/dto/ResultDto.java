package me.shnaps.productexpo.dto;

public class ResultDto {
    private PaymentDto paymentDto;
    private UserDto userDto;

    public ResultDto(PaymentDto paymentDto, UserDto userDto) {
        this.paymentDto = paymentDto;
        this.userDto = userDto;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
