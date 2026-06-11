package com.smartCity.repository;

import com.smartCity.objects.users.UserHistory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE UserHistory SET timesUsed = ? WHERE HistoryID = ?")
    void updateTimesUsedByHistoryID(Integer timesUsed, Integer historyID);

}
