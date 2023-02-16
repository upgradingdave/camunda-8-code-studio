package org.example.camunda.process.solution;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(Include.NON_NULL)
public class ProcessVariables {

  @JsonProperty("person_uuid")
  private String personUuid;

  @JsonProperty("recovery_certificate_uuid")
  private String recoveryCertificateUuid;

  public String getPersonUuid() {
    return personUuid;
  }

  public ProcessVariables setPersonUuid(String personUuid) {
    this.personUuid = personUuid;
    return this;
  }

  public String getRecoveryCertificateUuid() {
    return recoveryCertificateUuid;
  }

  public ProcessVariables setRecoveryCertificateUuid(String recoveryCertificateUuid) {
    this.recoveryCertificateUuid = recoveryCertificateUuid;
    return this;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(
        this,
        new MultilineRecursiveToStringStyle() {
          public ToStringStyle withShortPrefixes() {
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
            return this;
          }
        }.withShortPrefixes());
  }
}
