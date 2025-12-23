package com.xworkz.subscriptionplan.repository;

import com.xworkz.subscriptionplan.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionRepository {

    SubscriptionEntity saveSubscriptionInfo(SubscriptionEntity entity);
    boolean updatePriceDurationMonthsMaxUsersById(double price, int durationMonths, int maxUsers, int planId);
    SubscriptionEntity updateAllDetailById(SubscriptionEntity entity);
    boolean deleteById(int id);
    SubscriptionEntity findSubscriptionPlanById(int id);
    List<SubscriptionEntity> findAllDetails();
}
