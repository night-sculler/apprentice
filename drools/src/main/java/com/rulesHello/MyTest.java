package com.rulesHello;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/22
 */
public class MyTest {

    @Test
    public void testContains() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession("testContains");


        Person person = new Person();
        person.setName("张三");
        kieSession.insert(person);
        int count = kieSession.fireAllRules();
        System.out.println("执行了" + count + "条数据");
        kieSession.dispose();
    }

    @Test
    public void testQuery() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession("testQuery");

        Person person1 = new Person("张三", 35);
        Person person2 = new Person("李四", 30);
        Person person3 = new Person("王五", 50);
        Person person4 = new Person("张小三", 30);

        kieSession.insert(person1);
        kieSession.insert(person2);
        kieSession.insert(person3);
        kieSession.insert(person4);

        QueryResults queryResults = kieSession.getQueryResults("person age is 30 and name is 张小三", "李四");
        for (QueryResultsRow resultsRow : queryResults) {
            Person person = (Person) resultsRow.get("person");
            System.out.println(person);
        }
    }
}
