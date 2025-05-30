package com.starter.play.request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequest {
    @NotNull(message = "{constraints.NotEmpty.message}")
    private Long customerId;
    private Long branchId;
    private BigDecimal balance;

}
