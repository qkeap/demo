package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;

public interface ModelConverter {
  Task ConvertTaskDTOToDomainModel(TaskDTO dto);
  Contact ConvertContactDTOToDomainModel(ContactDTO dto);
  TaskDTO ConvertTaskDomainModelToDTO(Task model);
  ContactDTO ConvertContactDomainModelToDTO(Contact model);
}
