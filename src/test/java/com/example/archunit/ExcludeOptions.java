package com.example.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;

final class ExcludeOptions implements ImportOption {
    @Override
    public boolean includes(Location location) {
        return !location.contains("Foo.class");
    }
}

