package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;
import org.springframework.stereotype.Service;

@Service
public class ModelConverterDefaultImpl implements ModelConverter {

  @Override
  public Task ConvertTaskDTOToDomainModel(TaskDTO dto) {
    return new Task(
        dto.getId(),
        dto.getTitle(),
        dto.isCompleted(),
        ConvertContactDTOToDomainModel(dto.getContact()));
  }

  @Override
  public Contact ConvertContactDTOToDomainModel(ContactDTO dto) {
    return new Contact(dto.getId(), dto.getEmail(), dto.getFirstName(), dto.getLastName());
  }

  @Override
  public TaskDTO ConvertTaskDomainModelToDTO(Task model) {
    return new TaskDTO(
        model.getId(),
        model.getTitle(),
        model.isCompleted(),
        ConvertContactDomainModelToDTO(model.getContact()));
  }

  @Override
  public ContactDTO ConvertContactDomainModelToDTO(Contact model) {
    return new ContactDTO(
        model.getId(), model.getEmail(), model.getFirstName(), model.getLastName());
  }
}
