import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Product {
    private long id;
    private String nombre;
    private Double precio;
    private LocalDate fechaRegistro;

}