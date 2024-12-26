package com.store.stockapi.dto;


import com.store.stockapi.enums.PaymentType;
import com.store.stockapi.model.Item;

import java.util.List;

public class PurchaseDTO {


    String purchaseId;

    String clientId;

    List<Item> items;

    PaymentType paymentType;

    Double totalCost;

}
