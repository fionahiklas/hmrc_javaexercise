package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by fiona on 07/12/2016.
 */
public class ItemPriceTest {

  public static final long APPLE_ID = 12345;
  public static final String APPLE_DESCRIPTION = "Apple";
  public static final int APPLE_PRICE = 60;

  private ItemPrice itemPrice;

  @Before
  public void setup() {
    itemPrice = new ItemPrice(APPLE_ID, APPLE_DESCRIPTION, APPLE_PRICE);
    assertThat(itemPrice, notNullValue());
  }

  @Test
  public void testItemPriceAccessors() {
    assertThat(itemPrice.getId(), equalTo(APPLE_ID));
    assertThat(itemPrice.getDescription(), equalTo(APPLE_DESCRIPTION));
    assertThat(itemPrice.getPriceInPence(), equalTo(APPLE_PRICE));
  }

}
