package com.hiklas.mucking.around;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

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

}
