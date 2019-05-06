package com.rbc.shopping.domain;

import java.util.Map;

/**
*
* @author rmazumde
*/

public class Basket {
    private Map<String, Integer> items;

    public Basket(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
