package com.q.onboarding.demo;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.ModelConverterDefaultImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ModelConverterDefaultImplTests {
  private ModelConverter converter;
  private Task taskTemplate;
  private TaskDTO taskDTOTemplate;

  @Before
  public void setup() {
    converter = new ModelConverterDefaultImpl();
    taskTemplate = new Task("test", false, Mockito.mock(Contact.class));
    taskDTOTemplate = new TaskDTO("test", false, Mockito.mock(ContactDTO.class));
  }

  @Test
  public void convertTaskDTOToDomainSucceedsOnValidData() {
    TaskDTO dto = converter.convertTaskDomainModelToDTO(taskTemplate);
    Assert.assertEquals(dto.getTitle(), taskTemplate.getTitle());
    Assert.assertEquals(dto.isCompleted(), taskTemplate.isCompleted());
    Assert.assertEquals(dto.getContact().getId(), taskTemplate.getContact().getId());
  }

  @Test
  public void convertTaskDomainModelToDTOSucceedsOnValidData() {
    Task task = converter.convertTaskDTOToDomainModel(taskDTOTemplate);
    Assert.assertEquals(task.getTitle(), taskDTOTemplate.getTitle());
    Assert.assertEquals(task.isCompleted(), taskDTOTemplate.isCompleted());
    Assert.assertEquals(task.getContact().getId(), taskDTOTemplate.getContact().getId());
  }

  @Test(expected = NullPointerException.class)
  public void convertTaskDomainModelToDTOFailsOnMissingContact() {
    Task task = new Task("test", false, null);
    converter.convertTaskDomainModelToDTO(task);
  }

  @Test(expected = NullPointerException.class)
  public void convertTaskDTOToDomainModelFailsOnMissingContact() {
    TaskDTO dto = new TaskDTO("test", false, null);
    converter.convertTaskDTOToDomainModel(dto);
  }
}
