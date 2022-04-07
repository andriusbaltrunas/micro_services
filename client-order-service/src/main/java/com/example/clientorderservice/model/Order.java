package com.example.clientorderservice.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.*;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Setter
@Getter
@Document(collectionName = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Order {
    private @DocumentId
    String id;
    private String userId;
    private List<Product> products;
    private double totalPrice;
}
