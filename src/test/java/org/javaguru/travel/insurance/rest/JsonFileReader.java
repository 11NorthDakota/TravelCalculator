package org.javaguru.travel.insurance.rest;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class JsonFileReader {
    public String readFile(String fileName){
        try{
            byte[] file = Files.readAllBytes(Paths.get(getUrl(fileName)));
            return new String(file, StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    private URI getUrl(String fileName){
        return Optional.ofNullable(getClass().getClassLoader().getResource(fileName))
                .map(
                        url -> {
                            try{
                                System.out.println(url);
                                return url.toURI();
                            }catch (URISyntaxException e){
                                throw new RuntimeException(e);
                            }
                        }
                ).orElseThrow(()->new IllegalArgumentException("File not found"));
    }
}
