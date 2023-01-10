package DTO;

import com.accenture.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private UUID productId;
    private String productName;
    private Long price;
    private Integer quantity;
    private Category category;
}
