package com.hiklas.mucking.around;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static com.hiklas.mucking.around.DiscountPriceList.OfferType;
import static com.hiklas.mucking.around.DiscountPriceList.Offer;


/**
 *
 */
public class DiscountPriceListTest {

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
    DiscountPriceList discountPriceList = new DiscountPriceList(dummyPriceList);

    assertThat(discountPriceList, notNullValue());
  }

  @Test
  public void testPriceForOneItem() {
    PriceList dummyPriceList = createDummyPriceList();
    DiscountPriceList discountPriceList = new DiscountPriceList(dummyPriceList);

    ItemPrice result = discountPriceList.getItemPrice(1);

    assertThat(result.getId(), equalTo(1L));
    assertThat(result.getDescription(), equalTo("Dummy1"));
    assertThat(result.getPriceInPence(), equalTo(201));
  }

  private PriceList createDummyPriceList() {
    return new PriceList() {
      public ItemPrice getItemPrice(long id) {
        return new ItemPrice(id, "Dummy" + id, (int)(200+id));
      }
    };
  }
}
