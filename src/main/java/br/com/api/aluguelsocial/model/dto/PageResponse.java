package br.com.api.aluguelsocial.model.dto;

import java.util.List;

public record PageResponse<B>(
        List<B> content,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
}
