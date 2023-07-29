package io.red.alice.controllers.requests;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull(message = "Necessario nomear a categoria")
        String name
) {
}
