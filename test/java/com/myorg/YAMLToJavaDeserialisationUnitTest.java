package com.myorg;

import org.junit.Test;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class YAMLToJavaDeserialisationUnitTest {

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectMap() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/customer.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        assertEquals("John", obj.get("firstName"));
        assertEquals("Doe", obj.get("lastName"));
        assertEquals(20, obj.get("age"));
    }
}
