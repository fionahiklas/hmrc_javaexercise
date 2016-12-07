package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.junit.Before;

public class CheckoutTest
{
  private PriceList priceList;
  private Checkout checkoutTotest;

  @Before
  public void setup() {
    checkoutTotest = new Checkout(priceList);
  }

  @Test
  public void testCheckoutCreation() {
    assertThat(checkoutTotest, notNullValue());
  }
}
