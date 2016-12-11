package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutTest
{
  @Mock
  private PriceList priceList;

  private ItemPrice testItemPrice_one;
  private ItemPrice testItemPrice_two;

  private Checkout checkoutTotest;

  @Before
  public void setup() {
    checkoutTotest = new Checkout(priceList);
    testItemPrice_one = new ItemPrice(1,"Vimes", 20);
    testItemPrice_two = new ItemPrice(10,"Mort", 60);
  }

  @Test
  public void testCheckoutCreation() {
    assertThat(checkoutTotest, notNullValue());
  }

  @Test
  public void testCreateReceipt_oneItemCallsPriceList() {
    when(priceList.getItemPrice(1)).thenReturn(testItemPrice_one);
    long[] itemsToTest = { 1 };

    checkoutTotest.createTheReceipt(itemsToTest);
    verify(priceList).getItemPrice(1);
  }

  @Test
  public void testCreateReceipt_threeItemsCallsPriceList() {
    when(priceList.getItemPrice(1)).thenReturn(testItemPrice_one);
    long[] itemsToTest = { 1, 1, 1 };

    checkoutTotest.createTheReceipt(itemsToTest);
    verify(priceList, times(3)).getItemPrice(1);
  }

  @Test
  public void testCreateReceipt_sixDifferentItemsCallsPriceList() {
    when(priceList.getItemPrice(1)).thenReturn(testItemPrice_one);
    when(priceList.getItemPrice(10)).thenReturn(testItemPrice_two);
    long[] itemsToTest = { 1, 10, 1, 1, 10, 10 };

    checkoutTotest.createTheReceipt(itemsToTest);
    verify(priceList, times(3)).getItemPrice(1);
    verify(priceList, times(3)).getItemPrice(10);
  }

  @Test
  public void testCreateReceipt_oneItemOutput() {
    long[] itemsToTest = { 1 };

    when(priceList.getItemPrice(1)).thenReturn(testItemPrice_one);

    String result = checkoutTotest.createTheReceipt(itemsToTest);
    assertThat(result, equalTo("Vimes 20\nTOTAL: 20"));
  }

  @Test
  public void testCreateReceipt_ThreeItemOutput() {
    long[] itemsToTest = { 1, 10, 1 };

    when(priceList.getItemPrice(1)).thenReturn(testItemPrice_one);
    when(priceList.getItemPrice(10)).thenReturn(testItemPrice_two);

    String result = checkoutTotest.createTheReceipt(itemsToTest);
    assertThat(result, equalTo("Vimes 20\nMort 60\nVimes 20\nTOTAL: 100"));
  }

}
