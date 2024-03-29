package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public
class Purchaseitem {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int count;
}