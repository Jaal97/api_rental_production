package co.edu.unab.apirestg03.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("autos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutoModelo {
    @Id
    private String id;
    private long ndeserie;
    private String marca;
    private String matricula; //nregistro
    private String modelo;    
}
