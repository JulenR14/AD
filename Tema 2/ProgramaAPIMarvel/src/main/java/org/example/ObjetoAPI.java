package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ObjetoAPI {

    Info info;
    List<Location> results;

    public ObjetoAPI(Info info, List<Location> results){
        this.info = info;
        this.results = results;
    }

}
