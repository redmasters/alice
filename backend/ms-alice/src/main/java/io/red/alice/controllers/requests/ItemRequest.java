package io.red.alice.controllers.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemRequest(
    @NotEmpty(message = "Nome do item é obrigatório")
    String name,
    @NotEmpty(message = "Descrição do item é obrigatória")
    String description,
    @NotNull(message = "Peso do item é obrigatório")
    double weight,
    @NotEmpty(message = "Unidade de medida do item é obrigatória")
    String unit,
    @NotEmpty(message = "Código de barras do item é obrigatório")
    String barCode,
    @NotNull(message = "Data de validade do item é obrigatória")
    LocalDate dueDate,
    @NotNull(message = "Categoria do item é obrigatória")
    Long categoryId
) {
}
