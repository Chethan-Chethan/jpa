package com.xworkz.subscriptionplan.service;

import com.xworkz.subscriptionplan.entity.SubscriptionEntity;
import com.xworkz.subscriptionplan.repository.SubscriptionRepository;
import com.xworkz.subscriptionplan.repository.SubscriptionRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService{

    SubscriptionRepository repository = new SubscriptionRepositoryImpl();
    @Override
    public SubscriptionEntity validateAndSaveSubscriptionInfo(SubscriptionEntity entity) {
        System.out.println("Invoking validation");
        SubscriptionEntity saveValid = null;

        if (entity != null) {
            saveValid = repository.saveSubscriptionInfo(entity);
        } else {
            saveValid = null;
        }
        return saveValid;
    }

    @Override
    public boolean validateAndUpdatePriceDurationMonthsMaxUsersById(double price, int durationMonths, int maxUsers, int planId) {
        System.out.println("Invoking validation");
        boolean validUpdate = false;

        if (price>0 && durationMonths>0 && maxUsers>0 && planId>0) {
            validUpdate = repository.updatePriceDurationMonthsMaxUsersById(price, durationMonths, maxUsers, planId);
        } else {
            validUpdate = false;
        }
        return validUpdate;
    }

    @Override
    public SubscriptionEntity validateAndUpdateAllDetailById(SubscriptionEntity entity) {
        System.out.println("Invoking validation of update all");
        SubscriptionEntity updateAllValid = null;

        if (entity != null) {
            updateAllValid = repository.updateAllDetailById(entity);
        } else {
            updateAllValid = null;
        }
        return updateAllValid;
    }

    @Override
    public boolean validateAndDeleteById(int id) {
        System.out.println("Invoking delete validation");
        boolean deleteValid = false;

        if (id>0) {
            deleteValid = repository.deleteById(id);
        } else {
            deleteValid = false;
        }
        return deleteValid;
    }

    @Override
    public SubscriptionEntity validateAndFindSubscriptionPlanById(int id) {
        System.out.println("Validating delete");
        SubscriptionEntity validFetch = null;

        if (id>0) {
            validFetch = repository.findSubscriptionPlanById(id);
        } else {
            validFetch = null;
        }
        return validFetch;
    }

    @Override
    public List<SubscriptionEntity> validateAndFindAllDetails() {
        System.out.println("Invoking validation of all details");
        List<SubscriptionEntity> list = repository.findAllDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Subscription plan found: " + list.size());
        }
        return list;
    }

    @Override
    public List<SubscriptionEntity> validateAndGetPlanNamePriceDurationMonths(String planName, double price, int durationMonths) {
        System.out.println("Invoking validation");
        List<SubscriptionEntity> subscriptionEntities1 = null;

        if (planName!=null && !planName.isEmpty() && price>0 && durationMonths>0) {
            subscriptionEntities1 = repository.getPlanNamePriceDurationMonths(planName, price, durationMonths);
        } else {
            subscriptionEntities1 = null;
        }
        return subscriptionEntities1;
    }

    @Override
    public List<SubscriptionEntity> validateAndGetPlanNameMaxUsers(String planName, int maxUsers) {
        System.out.println("Invoking validation");
        List<SubscriptionEntity> subscriptionEntities2 = null;

        if (planName!=null && !planName.isEmpty() && maxUsers>0) {
            subscriptionEntities2 = repository.getPlanNameMaxUsers(planName, maxUsers);
        } else {
            subscriptionEntities2 = null;
        }
        return subscriptionEntities2;
    }
}
