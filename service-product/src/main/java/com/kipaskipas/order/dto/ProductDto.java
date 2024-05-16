package com.kipaskipas.order.dto;

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
public class ProductDto {

  @JsonProperty("id")
  private String id;

  @NotEmpty(message = "name_is_required")
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("stock")
  private Integer stock;

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
