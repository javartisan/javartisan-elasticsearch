//package com.javartisan.springboot.javartisanspringboot;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class UserBeanPostProcessor implements BeanPostProcessor {
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//
//        if (bean instanceof UserService) {
//            ((UserService) bean).setUserName("leo" + ((UserService) bean).getUserName());
//            System.out.println(beanName + ":" + ((UserService) bean).getUserName());
//        }
//
//
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof UserService) {
//            ((UserService) bean).setUserName("leo" + ((UserService) bean).getUserName());
//            System.out.println(beanName + ":" + ((UserService) bean).getUserName());
//        }
//
//        return bean;
//    }
//}
