package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

//    @Query(value = "select c from Notification c order by c.Notification")
//    List<Category> findAllCategoryByJPQL();

//    Optional<Notification> findUserEntityByUserId(String userId);
}
