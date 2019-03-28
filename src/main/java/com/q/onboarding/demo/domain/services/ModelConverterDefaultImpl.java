package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;
import org.springframework.stereotype.Service;

@Service
public class ModelConverterDefaultImpl implements ModelConverter {

  @Override
  public Task convertTaskDTOToDomainModel(TaskDTO dto) {
    return new Task(
        dto.getTitle(),
        dto.isCompleted(),
        convertContactDTOToDomainModel(dto.getContact()));
  }

  @Override
  public Contact convertContactDTOToDomainModel(ContactDTO dto) {
    return new Contact(dto.getId(), dto.getEmail(), dto.getFirstName(), dto.getLastName());
  }

  @Override
  public TaskDTO convertTaskDomainModelToDTO(Task model) {
    return new TaskDTO(
        model.getTitle(),
        model.isCompleted(),
        convertContactDomainModelToDTO(model.getContact()));
  }

  @Override
  public ContactDTO convertContactDomainModelToDTO(Contact model) {
    return new ContactDTO(
        model.getId(), model.getEmail(), model.getFirstName(), model.getLastName());
  }
}
