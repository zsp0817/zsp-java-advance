package com.zsp.schoolstarter;

import com.zsp.schoolstarter.bean.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangshaopeng on 2021/7/25.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        School school = (School) context.getBean("school");
        school.ding();
        school.getKlass().dong();
    }

}
