package com.hiklas.mucking.around;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static com.hiklas.mucking.around.ApplesAndOrangesDiscountPriceList.OfferType;
import static com.hiklas.mucking.around.ApplesAndOrangesDiscountPriceList.Offer;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.APPLE_ID;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.ORANGE_ID;



/**
 *
 */
public class ApplesAndOrangesDiscountPriceListTest {

  public static final long ITEM_ID = 1;

  @Test
  public void testEnumHowManyBeforeFreeItem() {
    OfferType bogof = OfferType.BOGOF;
    OfferType threeForTwo = OfferType.THREEFORTWO;

    assertThat(bogof.getHowManyBeforeFreeItem(), equalTo(2));
    assertThat(threeForTwo.getHowManyBeforeFreeItem(), equalTo(3));
  }

  @Test
  public void testCreateOffer() {
    Offer offer = new Offer(ITEM_ID, OfferType.THREEFORTWO);
    assertThat(offer, notNullValue());
    assertThat(offer.getId(), equalTo(ITEM_ID));
    assertThat(offer.getType(), equalTo(OfferType.THREEFORTWO));
  }

  @Test
  public void testCreateDiscountPriceList() {
    PriceList dummyPriceList = createDummyPriceList();
    ApplesAndOrangesDiscountPriceList discountPriceList = new ApplesAndOrangesDiscountPriceList(dummyPriceList);

    assertThat(discountPriceList, notNullValue());
  }

  @Test
  public void testPriceForOneItem() {
    PriceList dummyPriceList = createDummyPriceList();
    ApplesAndOrangesDiscountPriceList discountPriceList = new ApplesAndOrangesDiscountPriceList(dummyPriceList);

    ItemPrice result = discountPriceList.getItemPrice(1);

    assertThat(result.getId(), equalTo(1L));
    assertThat(result.getDescription(), equalTo("Dummy1"));
    assertThat(result.getPriceInPence(), equalTo(201));
  }

  @Test
  public void testPriceForOneAppleAndOrange() {
    PriceList dummyPriceList = createDummyPriceList();
    ApplesAndOrangesDiscountPriceList discountPriceList = new ApplesAndOrangesDiscountPriceList(dummyPriceList);

    ItemPrice applePrice = discountPriceList.getItemPrice(APPLE_ID);
    ItemPrice orangePrice = discountPriceList.getItemPrice(ORANGE_ID);

    assertThat(applePrice.getId(), equalTo(APPLE_ID));
    assertThat(applePrice.getDescription(), equalTo("Dummy"+APPLE_ID));
    assertThat(applePrice.getPriceInPence(), equalTo((int)(200+APPLE_ID)));

    assertThat(orangePrice.getId(), equalTo(ORANGE_ID));
    assertThat(orangePrice.getDescription(), equalTo("Dummy"+ORANGE_ID));
    assertThat(orangePrice.getPriceInPence(), equalTo((int)(200+ORANGE_ID)));

  }


  private PriceList createDummyPriceList() {
    return new PriceList() {
      public ItemPrice getItemPrice(long id) {
        return new ItemPrice(id, "Dummy" + id, (int)(200+id));
      }
    };
  }
}
