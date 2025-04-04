package org.javaguru.travel.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreResponse {

    private List<ValidationError> errors;

    public boolean hasErrors(){
        return errors != null && !errors.isEmpty();
    }



}
