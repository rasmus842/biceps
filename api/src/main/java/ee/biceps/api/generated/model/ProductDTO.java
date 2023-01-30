package ee.biceps.api.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-31T00:11:07.611698567+02:00[Europe/Tallinn]")
public class ProductDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private Integer price;

  @JsonProperty("unit")
  private String unit;

  @JsonProperty("availableAmount")
  private Integer availableAmount;

  public ProductDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Id given by database, undefined in request body.
   * @return id
  */
  
  @Schema(name = "id", example = "0", description = "Id given by database, undefined in request body.", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProductDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "T-shirt", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", example = "1", required = false)
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ProductDTO unit(String unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
  */
  
  @Schema(name = "unit", example = "piece", required = false)
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public ProductDTO availableAmount(Integer availableAmount) {
    this.availableAmount = availableAmount;
    return this;
  }

  /**
   * Get availableAmount
   * @return availableAmount
  */
  
  @Schema(name = "availableAmount", example = "5", required = false)
  public Integer getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(Integer availableAmount) {
    this.availableAmount = availableAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDTO productDTO = (ProductDTO) o;
    return Objects.equals(this.id, productDTO.id) &&
        Objects.equals(this.name, productDTO.name) &&
        Objects.equals(this.price, productDTO.price) &&
        Objects.equals(this.unit, productDTO.unit) &&
        Objects.equals(this.availableAmount, productDTO.availableAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, unit, availableAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    availableAmount: ").append(toIndentedString(availableAmount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

