package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.APPLE_ID;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.ORANGE_ID;

import org.junit.Test;

/**
 * Test the full end to end solution
 */
public class FullTest {


  @Test
  public void testExampleWithNormalPriceList() {
    PriceList priceList = new ApplesAndOrangesPriceList();
    Checkout checkout = new Checkout(priceList);

    long[] items = { APPLE_ID, APPLE_ID, ORANGE_ID, APPLE_ID };
    String result = checkout.createTheReceipt(items);

    assertThat(result, equalTo("Apple 60\nApple 60\nOrange 25\nApple 60\nTOTAL: 205"));
  }

  @Test
  public void testLongerExampleWithNormalPriceList() {
    PriceList priceList = new ApplesAndOrangesPriceList();
    Checkout checkout = new Checkout(priceList);

    long[] items = { APPLE_ID, ORANGE_ID, APPLE_ID, ORANGE_ID, APPLE_ID, APPLE_ID, APPLE_ID };
    String result = checkout.createTheReceipt(items);

    assertThat(result, equalTo("Apple 60\nOrange 25\nApple 60\nOrange 25\nApple 60\nApple 60\nApple 60\nTOTAL: 350"));
  }

  @Test
  public void testExampleWithDiscountPriceList() {
    PriceList actualPriceList = new ApplesAndOrangesPriceList();
    PriceList priceList = new ApplesAndOrangesDiscountPriceList(actualPriceList);
    Checkout checkout = new Checkout(priceList);

    long[] items = { ORANGE_ID, APPLE_ID, ORANGE_ID, ORANGE_ID };
    String result = checkout.createTheReceipt(items);

    assertThat(result, equalTo("Orange 25\nApple 60\nOrange 25\nOrange discount -25 0\nTOTAL: 110"));
  }

  @Test
  public void testLongerExampleWithDiscountPriceList() {
    PriceList actualPriceList = new ApplesAndOrangesPriceList();
    PriceList priceList = new ApplesAndOrangesDiscountPriceList(actualPriceList);
    Checkout checkout = new Checkout(priceList);

    long[] items = { APPLE_ID, ORANGE_ID, APPLE_ID, ORANGE_ID, APPLE_ID, APPLE_ID, APPLE_ID };
    String result = checkout.createTheReceipt(items);

    assertThat(result, equalTo("Apple 60\nOrange 25\nApple discount -60 0\nOrange 25\nApple 60\nApple discount -60 0\nApple 60\nTOTAL: 230"));
  }

}
