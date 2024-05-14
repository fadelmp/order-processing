package com.kipaskipas.order.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

  @JsonProperty("id")
  private String id;

  @NotEmpty(message = "customer_is_required")
  @JsonProperty("customer_id")
  private String customerId;

  @NotEmpty(message = "customer_name_is_required")
  @JsonProperty("customer_name")
  private String customerName;

  @NotEmpty(message = "product_is_required")
  @JsonProperty("product_id")
  private String productId;

  @NotEmpty(message = "product_name_is_required")
  @JsonProperty("product_name")
  private String productName;

  @NotEmpty(message = "amount_is_required")
  @JsonProperty("amount")
  private BigDecimal amount;

  @NotEmpty(message = "quantity_is_required")
  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("is_actived")
  public Boolean isActived;

  @JsonProperty("created_at")
  public Date createdAt;

  @JsonProperty("created_by")
  public String createdBy;

  @JsonProperty("updated_at")
  public Date updatedAt;

  @JsonProperty("updated_by")
  public String updatedBy;

}
