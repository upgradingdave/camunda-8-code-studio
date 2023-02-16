package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import java.util.UUID;
import org.example.camunda.process.solution.ProcessVariables;
import org.example.camunda.process.solution.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HZVWorker {

  static Logger logger = LoggerFactory.getLogger(HZVWorker.class.getName());

  private static final Logger LOG = LoggerFactory.getLogger(HZVWorker.class);

  private final MyService myService;

  public HZVWorker(MyService myService) {
    this.myService = myService;
  }

  @JobWorker(type = "notify_person_to_quarantine")
  public void notifyPersonToQuarantine(@VariablesAsType ProcessVariables variables) {
    logger.info(
        "Retrieving contact details for person "
            + variables.getPersonUuid()
            + " from external database...");
    logger.info(
        "Sending notification to person " + variables.getPersonUuid() + " to quarantine...");
  }

  @JobWorker(type = "generate_certificate_of_recovery")
  public ProcessVariables generateCertificateOfRecovery(
      @VariablesAsType ProcessVariables variables) {
    UUID recovery_certificate_uuid = UUID.randomUUID();
    logger.info(
        "Generating certificate of recovery for person " + variables.getPersonUuid() + "...");
    logger.info("Generated certificate ID: " + recovery_certificate_uuid);
    logger.info("Storing Recovery Certificate in external database...");

    return new ProcessVariables().setRecoveryCertificateUuid(recovery_certificate_uuid.toString());
  }

  @JobWorker(type = "send_certificate_of_recovery")
  public void sendCertificateOfRecovery(@VariablesAsType ProcessVariables variables) {
    logger.info(
        "Retrieving Recovery Certificate "
            + variables.getRecoveryCertificateUuid()
            + " from external database...");
    logger.info(
        "Retrieving contact details for person "
            + variables.getPersonUuid()
            + "from external database...");
    logger.info(
        "Sending Recovery Certificate to person "
            + variables.getPersonUuid()
            + ". Enjoy that ice-cream!");
  }
}
