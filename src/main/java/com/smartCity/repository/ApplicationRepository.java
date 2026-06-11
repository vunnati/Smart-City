package com.smartCity.repository;

import com.smartCity.objects.applications.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findByApplicationID(Integer accountID);

    List<Application> findByAdminsAdminID(Integer adminID);

    Application findByApplicationName(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Application a SET a.customized = true WHERE a.applicationID = :applicationId")
    void updateCustomizedStatusToTrue(Integer applicationId);

}
