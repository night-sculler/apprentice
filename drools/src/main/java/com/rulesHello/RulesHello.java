package com.rulesHello;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/21
 */
public class RulesHello {
    public static void main(String[] args) {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("testhelloworld");
        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        System.out.println(person);
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总共执行了：" + count + "条规则");
        System.out.println(person);
        ks.dispose();
    }
}
