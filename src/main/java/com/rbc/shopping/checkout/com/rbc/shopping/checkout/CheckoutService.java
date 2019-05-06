package com.rbc.shopping.checkout;

import com.rbc.shopping.domain.Basket;

import java.math.BigDecimal;

/**
*
* @author rmazumde
*/

public interface CheckoutService {
    BigDecimal generateBill(Basket basket);
}
