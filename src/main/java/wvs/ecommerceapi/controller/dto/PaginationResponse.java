package wvs.ecommerceapi.controller.dto;

public record PaginationResponse(Integer page,
                                 Integer pageSize,
                                 Integer totalPages,
                                 Long totalElements) {
}
