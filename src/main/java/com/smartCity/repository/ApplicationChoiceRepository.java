package com.smartCity.repository;

import com.smartCity.objects.applications.ApplicationChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationChoiceRepository extends JpaRepository<ApplicationChoices, Integer> {

    ApplicationChoices findByApplicationApplicationID(Integer applicationID);

}
