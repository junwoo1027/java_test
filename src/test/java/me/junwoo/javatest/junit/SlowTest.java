package me.junwoo.javatest.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Tag("slow")
@Test
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SlowTest {
}
