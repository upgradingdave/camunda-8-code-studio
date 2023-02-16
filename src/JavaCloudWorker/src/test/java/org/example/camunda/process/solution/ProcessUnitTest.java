package org.example.camunda.process.solution;


import io.camunda.zeebe.process.test.api.ZeebeTestEngine;
import io.camunda.zeebe.spring.test.ZeebeSpringTest;
import org.example.camunda.process.solution.facade.ProcessController;
import org.example.camunda.process.solution.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @see
 *     https://docs.camunda.io/docs/components/best-practices/development/testing-process-definitions/#writing-process-tests-in-java
 */
@SpringBootTest(classes = ProcessApplication.class) // will deploy BPMN & DMN models
@ZeebeSpringTest
public class ProcessUnitTest {

  @Autowired private ProcessController processController;

  @Autowired private ZeebeTestEngine engine;

  @MockBean private MyService myService;

  @Test
  // As bonus points, see if we can define a test
  public void testHappyPath() throws Exception {}
}
