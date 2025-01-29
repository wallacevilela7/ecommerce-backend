package wvs.ecommerceapi.controller.dto;

import java.util.List;

public record ApiResponse<T>(
        List<T> data,
        PaginationResponse paginationResponse) {
}
