package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutTest
{
  @Mock
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

  @Test
  public void testCreateReceipt_oneItemCallsPriceList() {
    when(priceList.getItemPrice(1)).thenReturn(null);
    long[] itemsToTest = { 1 };

    checkoutTotest.createTheReceipt(itemsToTest);
    
    verify(priceList).getItemPrice(1);
  }
}
