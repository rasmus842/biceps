package ee.biceps.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ErrorMessage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-02T21:18:03.823447551+02:00[Europe/Tallinn]")
public class ErrorMessage {

  @JsonProperty("title")
  private String title;

  @JsonProperty("statusCode")
  private Integer statusCode;

  @JsonProperty("detail")
  private String detail;

  public ErrorMessage title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A short summary about the error type.
   * @return title
  */
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorMessage statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * The HTTP status code generated by the origin server for this occurrence of the problem.
   * minimum: 100
   * maximum: 600
   * @return statusCode
  */
  @Min(100) @Max(600) 
  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public ErrorMessage detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human readable explanation specific to this occurrence of the problem.
   * @return detail
  */
  
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.title, errorMessage.title) &&
        Objects.equals(this.statusCode, errorMessage.statusCode) &&
        Objects.equals(this.detail, errorMessage.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, statusCode, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

