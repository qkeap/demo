package com.q.onboarding.demo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.ModelConverterDefaultImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModelConverterDefaultImplTests {
  private ModelConverter converter;
  private Task taskTemplate;
  private TaskDTO taskDTOTemplate;
  private Contact contactTemplate;
  private ContactDTO contactDTOTemplate;

  @Before
  public void setup(){
    converter = new ModelConverterDefaultImpl();
    taskTemplate = new Task("test", false, Mockito.mock(Contact.class));
    taskDTOTemplate = new TaskDTO("test", false, Mockito.mock(ContactDTO.class));;
  }

  @Test
  public void convertTaskDTOToDomainSucceedsOnValidData() {
    TaskDTO dto = converter.convertTaskDomainModelToDTO(taskTemplate);
    assertThat(dto.getTitle()).isEqualTo(taskTemplate.getTitle());
  }

  @Test
  public void convertTaskDomainModelToDTOSucceedsOnValidData(){
    Task task = converter.convertTaskDTOToDomainModel(taskDTOTemplate);
    assertThat(task.getTitle()).isEqualTo(taskDTOTemplate.getTitle());
  }

  @Test(expected = NullPointerException.class)
  public void convertTaskDomainModelToDTOFailsOnMissingContact(){
    Task task = new Task("test", false, null);
    converter.convertTaskDomainModelToDTO(task);
  }

  @Test(expected = NullPointerException.class)
  public void convertTaskDTOToDomainModelFailsOnMissingContact(){
    TaskDTO dto = new TaskDTO("test", false, null);
    converter.convertTaskDTOToDomainModel(dto);
  }
}
