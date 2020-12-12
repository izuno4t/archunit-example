package com.example.archunit;

import com.tngtech.archunit.PublicAPI;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.tngtech.archunit.PublicAPI.Usage.ACCESS;
import static com.tngtech.archunit.lang.conditions.ArchConditions.callMethod;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.archunit")
public final class MyCodingRuleTest {

    private MyCodingRuleTest() {
    }

    @PublicAPI(usage = ACCESS)
    public static final ArchCondition<JavaClass> USE_LOCALDATE_NOW = createJavaTimeNow();

    private static ArchCondition<JavaClass> createJavaTimeNow() {
        ArchCondition<JavaClass> useLocalDateNow = callMethod(LocalDate.class, "now");
        ArchCondition<JavaClass> useLocalDateTimeNow = callMethod(LocalDateTime.class, "now");
        return useLocalDateNow.or(useLocalDateTimeNow).as("use SystemDateTime#now or SystemDateTime#today");
    }

    @PublicAPI(usage = ACCESS)
    public static final ArchRule NO_CLASSES_SHOULD_USE_LOCALDATE_NOW =
            noClasses().should(USE_LOCALDATE_NOW).because("don't use primitive instance LocalDate#now");


    @ArchTest
    private final ArchRule no_classes_should_use_localdate_now = NO_CLASSES_SHOULD_USE_LOCALDATE_NOW;

}
