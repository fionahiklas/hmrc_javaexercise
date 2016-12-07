package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.APPLE_ID;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.ORANGE_ID;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by fiona on 07/12/2016.
 */
public class ApplesAndOrangesPriceListTest {

  private ApplesAndOrangesPriceList priceListInstance;

  @Before
  public void setup() {
    priceListInstance = new ApplesAndOrangesPriceList();
  }

  @Test
  public void testCreationOfPriceList() {
    assertThat(priceListInstance, notNullValue());
  }

  @Test
  public void testTypeOfPriceList() {
    assertThat(priceListInstance, instanceOf(PriceList.class));
  }

  @Test
  public void testApplePriceItem() {
    ItemPrice itemPrice = priceListInstance.getItemPrice(APPLE_ID);
    assertThat(itemPrice.getId(), equalTo(APPLE_ID));
    assertThat(itemPrice.getDescription(), equalTo("Apple"));
    assertThat(itemPrice.getPriceInPence(), equalTo(60));
  }

  @Test
  public void testOrangePriceItem() {
    ItemPrice itemPrice = priceListInstance.getItemPrice(ORANGE_ID);
    assertThat(itemPrice.getId(), equalTo(ORANGE_ID));
    assertThat(itemPrice.getDescription(), equalTo("Orange"));
    assertThat(itemPrice.getPriceInPence(), equalTo(25));
  }

}
