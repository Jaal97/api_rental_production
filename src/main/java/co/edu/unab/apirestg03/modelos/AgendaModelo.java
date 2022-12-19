package co.edu.unab.apirestg03.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

@Document("agendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgendaModelo {
    @Id
    private String id;
    private String id_auto;
    private String marcaauto;
    private String modelo;
    private LocalDate fecha;
    // private List<String> citas;      
}
