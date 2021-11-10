package com.night.sculler.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 自定义class文件转换器
 *
 * @author night -sculler
 * @version 1.0.0.release
 * @date 2021 /10/28
 */
public class Transformer implements ClassFileTransformer {
    /**
     * 目标类名称 .分隔
     */
    private final String targetClassName;
    /**
     * 目标方法名
     */
    private final String targetMethodName;

    /**
     * Instantiates a new Transformer.
     *
     * @param targetClassName  the target class name
     * @param targetMethodName the target method name
     */
    public Transformer(String targetClassName, String targetMethodName) {
        this.targetClassName = targetClassName;
        this.targetMethodName = targetMethodName;
    }

    /**
     * Gets target class name.
     *
     * @return the target class name
     */
    public String getTargetClassName() {
        return targetClassName;
    }

    /**
     * Gets target method name.
     *
     * @return the target method name
     */
    public String getTargetMethodName() {
        return targetMethodName;
    }

    /**
     * Gets target jvm class name.
     *
     * @return the target jvm class name
     */
    public String getTargetJvmClassName() {
        return targetClassName.replaceAll("\\.","\\/");
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals(getTargetJvmClassName())) {
            return classfileBuffer;
        }
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass cls = classPool.get(this.targetClassName);
            CtMethod ctMethod = cls.getDeclaredMethod(this.targetMethodName);
            ctMethod.insertBefore("{ System.out.println(\"start\"); }");
            ctMethod.insertAfter("{ System.out.println(\"end\"); }");
            return cls.toBytecode();
        } catch (Exception e) {
            return classfileBuffer;
        }
    }
}
