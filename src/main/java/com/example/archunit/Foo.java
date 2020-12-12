package com.example.archunit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Foo {

    public void callPrintStackTrace() {
        try {
            Path path = Files.createTempDirectory("foo");
            System.out.println(path.toAbsolutePath().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LocalDate callLocalDateNow() {
        return LocalDate.of(2020, 1, 1);
    }

    public LocalDateTime callLocalDateTimeNow() {
        return LocalDateTime.now();
//        return LocalDateTime.of(2020,1,1,12,34,56);
    }

}
