package com.smartCity.repository;

import com.smartCity.objects.message.UserMessages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessages, Integer> {

    UserMessages findByMessageID(Integer messageID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE UserMessages SET Processed = ? WHERE MessageID = ?")
    void markAsProcessed(boolean processed, Integer messageId);
}
