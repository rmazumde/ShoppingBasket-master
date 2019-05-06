package com.rbc.shopping.domain;

import com.rbc.shopping.exception.InvalidFruitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
*
* @author rmazumde
*/

public class FruitTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowInvalidFruitException_when_getFruit_givenInvalidFruit() {
        expectedException.expect(InvalidFruitException.class);
        expectedException.expectMessage("Invalid Fruit Pears");
        Fruit.getFruit("Pears");
    }

    @Test
    public void shouldReturnFruit_when_getFruit_givenValidFruit() {
        assertThat(Fruit.getFruit("Apple"), is(Fruit.APPLE));
        assertThat(Fruit.getFruit("Orange"), is(Fruit.ORANGE));
        assertThat(Fruit.getFruit("Lemon"), is(Fruit.LEMON));
        assertThat(Fruit.getFruit("Peach"), is(Fruit.PEACH));
        assertThat(Fruit.getFruit("Banana"), is(Fruit.BANANA));
    }
}