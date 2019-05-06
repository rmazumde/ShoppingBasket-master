package com.rbc.shopping.domain;

import com.rbc.shopping.exception.InvalidFruitException;
import java.math.BigDecimal;
import static java.util.stream.Stream.of;

/**
*
* @author rmazumde
*/

public enum Fruit {
    APPLE("Apple", BigDecimal.valueOf(0.60)),
    BANANA("Banana", BigDecimal.valueOf(0.40)),
    ORANGE("Orange", BigDecimal.valueOf(0.50)),
    PEACH("Peach", BigDecimal.valueOf(0.30)),
    LEMON("Lemon", BigDecimal.valueOf(0.20)),;

    private String name;
    private BigDecimal price;

    Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static Fruit getFruit(String fruitName) {
        return of(Fruit.values())
                .filter(fruit -> fruit.getName().equalsIgnoreCase(fruitName))
                .findFirst()
                .orElseThrow(() -> new InvalidFruitException("Invalid Fruit " + fruitName));
    }
}
