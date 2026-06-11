package com.smartCity.repository;

import com.smartCity.objects.message.AdminMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMessageRepository extends JpaRepository<AdminMessages, Integer> {

    AdminMessages findByMessageID(Integer messageID);
}
