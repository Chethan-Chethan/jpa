package com.xworkz.subscriptionplan.runner;

import com.xworkz.subscriptionplan.entity.SubscriptionEntity;
import com.xworkz.subscriptionplan.service.SubscriptionService;
import com.xworkz.subscriptionplan.service.SubscriptionServiceImpl;

import java.util.List;

public class SubscriptionRunner {

    public static void main(String[] args) {

        SubscriptionEntity obj = new SubscriptionEntity();
//        obj.setPlanName("Student Plan");
//        obj.setPrice(199.00);
//        obj.setDurationMonths(3);
//        obj.setMaxUsers(1);
//        obj.setActive(true);

        SubscriptionService service = new SubscriptionServiceImpl();

//        SubscriptionEntity saved = service.validateAndSaveSubscriptionInfo(obj);
//        System.out.println(saved);

//        boolean updating = service.validateAndUpdatePriceDurationMonthsMaxUsersById(399.00, 1,2, 1);
//        if (updating) {
//            System.out.println("Update successfull");
//        } else {
//            System.out.println("update failed");
//        }

//        obj.setPlanName("Advance Plan");
//        obj.setPrice(599);
//        obj.setDurationMonths(2);
//        obj.setMaxUsers(3);
//        obj.setActive(true);
//        obj.setPlanId(1);
//
//        SubscriptionEntity allUpdated = service.validateAndUpdateAllDetailById(obj);
//        System.out.println(allUpdated);

//        boolean deleting = service.validateAndDeleteById(2);
//        if (deleting) {
//            System.out.println("delete successful");
//        } else {
//            System.out.println("delete failed");
//        }

//        SubscriptionEntity fetching = service.validateAndFindSubscriptionPlanById(4);
//        System.out.println(fetching);

//        List<SubscriptionEntity> planEntity = service.validateAndFindAllDetails();
//        System.out.println(planEntity);

//        List<SubscriptionEntity> plan1 = service.validateAndGetPlanNamePriceDurationMonths("Premium Plan", 1499, 12);
//        System.out.println(plan1);

        List<SubscriptionEntity> plan2 = service.validateAndGetPlanNameMaxUsers("Enterprise Plan", 10);
        System.out.println(plan2);
    }
}
