package com.xworkz.subscriptionplan.service;

import com.xworkz.subscriptionplan.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionService {

    SubscriptionEntity validateAndSaveSubscriptionInfo(SubscriptionEntity entity);
    boolean validateAndUpdatePriceDurationMonthsMaxUsersById(double price, int durationMonths, int maxUsers, int planId);
    SubscriptionEntity validateAndUpdateAllDetailById(SubscriptionEntity entity);
    boolean validateAndDeleteById(int id);
    SubscriptionEntity validateAndFindSubscriptionPlanById(int id);
    List<SubscriptionEntity> validateAndFindAllDetails();
    List<SubscriptionEntity> validateAndGetPlanNamePriceDurationMonths(String planName, double price, int durationMonths);
    List<SubscriptionEntity> validateAndGetPlanNameMaxUsers(String planName, int maxUsers);
}
