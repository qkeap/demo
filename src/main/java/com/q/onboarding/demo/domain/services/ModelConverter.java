package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Contact;
import com.q.onboarding.demo.domain.models.Task;

public interface ModelConverter {
  Task convertTaskDTOToDomainModel(TaskDTO dto);

  Contact convertContactDTOToDomainModel(ContactDTO dto);

  TaskDTO convertTaskDomainModelToDTO(Task model);

  ContactDTO convertContactDomainModelToDTO(Contact model);
}
