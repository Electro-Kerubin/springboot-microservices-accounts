package com.nerfilin.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can't be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{9})", message = "AccountNumber must be 9 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type can't be a null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can't be a null or empty")
    private String branchAddress;
}
