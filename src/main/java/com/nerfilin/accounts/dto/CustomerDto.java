package com.nerfilin.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    
    @NotEmpty(message = "Name can't be a null or empty")
    @Size(min = 5, max = 30, message = "The leghth of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email can't be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
    private String mobileNumber;

    @NotNull
    private AccountsDto accountsDto;
}
