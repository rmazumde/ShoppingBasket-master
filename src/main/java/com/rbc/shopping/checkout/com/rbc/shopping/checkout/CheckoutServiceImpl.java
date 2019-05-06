package com.rbc.shopping.checkout;

import com.rbc.shopping.domain.Basket;
import com.rbc.shopping.exception.InvalidBasketException;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.BiFunction;

import static com.rbc.shopping.domain.Fruit.getFruit;
import static java.math.BigDecimal.*;
import static java.util.Objects.isNull;

/**
*
* @author rmazumde
*/

public class CheckoutServiceImpl implements CheckoutService {

    private BiFunction<Map<String, Integer>, String, BigDecimal> calculatePrice =
            (items, fruit) -> getPrice(fruit).multiply(valueOf(items.get(fruit)));

    @Override
    public BigDecimal generateBill(Basket basket) {
        validateBasket(basket);
        return getBasketPrice(basket.getItems());
    }

    private BigDecimal getBasketPrice(Map<String, Integer> items) {
        return items.keySet()
                .stream()
                .map(fruit -> calculatePrice.apply(items, fruit))
                .reduce(ZERO, BigDecimal::add);
    }

    private static void validateBasket(Basket basket) {
        if (isNull(basket.getItems())) {
            throw new InvalidBasketException("Invalid Basket");
        }
    }

    private BigDecimal getPrice(String fruit) {
        return getFruit(fruit).getPrice().setScale(2, ROUND_HALF_UP);
    }
}
