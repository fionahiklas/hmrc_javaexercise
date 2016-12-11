package com.hiklas.mucking.around;

import java.util.HashMap;

import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.APPLE_ID;
import static com.hiklas.mucking.around.ApplesAndOrangesPriceList.ORANGE_ID;

/**
 * Implementation of a price list that counts items for offers
 */
public class ApplesAndOrangesDiscountPriceList implements PriceList {

  private PriceList actualPriceList;
  private HashMap<Long, Offer> offerTable;
  private HashMap<Long, Integer> currentCount;

  private static final Offer APPLE_OFFER = new Offer(APPLE_ID, OfferType.BOGOF);
  private static final Offer ORANGE_OFFER = new Offer(ORANGE_ID, OfferType.THREEFORTWO);

  public ApplesAndOrangesDiscountPriceList(PriceList actualPriceList) {
    this.actualPriceList = actualPriceList;
    offerTable = new HashMap<Long, Offer>();
    offerTable.put(APPLE_ID, APPLE_OFFER);
    offerTable.put(ORANGE_ID, ORANGE_OFFER);

    currentCount = new HashMap<Long, Integer>();
    resetCount(APPLE_ID);
    resetCount(ORANGE_ID);
  }


  public ItemPrice getItemPrice(long id) {
    ItemPrice result = null;
    if(isOffer(id)) {
      result = calculateOfferPrice(id);
    } else {
      result = actualPriceList.getItemPrice(id);
    }
    return result;
  }


  private ItemPrice calculateOfferPrice(long itemId) {
    Offer offer = getOffer(itemId);
    int currentCount = incrementAndGetCount(itemId);

    ItemPrice itemPrice = actualPriceList.getItemPrice(itemId);
    if(countLessThanOfferNumber(currentCount, offer)) {
      return itemPrice;
    } else {
      resetCount(itemId);
      ItemPrice offerPrice = new ItemPrice(itemId,
        itemPrice.getDescription() + " discount -" + itemPrice.getPriceInPence(),
        0);
      return offerPrice;
    }
  }


  private boolean isOffer(long itemId) {
    return (getOffer(itemId) != null);
  }

  private Offer getOffer(long itemId) {
    return offerTable.get(itemId);
  }

  private boolean countLessThanOfferNumber(int count, Offer offer) {
    return count<offer.getType().getHowManyBeforeFreeItem();
  }

  private int incrementAndGetCount(long itemId) {
    int countIncremented = getCount(itemId) + 1;
    putCount(itemId, countIncremented);
    return countIncremented;
  }

  private int getCount(long itemId) {
    return currentCount.get(itemId);
  }

  private void putCount(long itemId, int count) {
    currentCount.put(itemId, count);
  }

  private void resetCount(long itemId) {
    putCount(itemId, 0);
  }


  // ///////////// //
  // Inner Classes //
  // ///////////// //


  public enum OfferType {
    BOGOF(2), THREEFORTWO(3);

    private int howManyBeforeFreeItem;

    OfferType(int howManyBeforeFreeItem) {
      this.howManyBeforeFreeItem = howManyBeforeFreeItem;
    }

    public int getHowManyBeforeFreeItem() {
      return this.howManyBeforeFreeItem;
    }
  }


  public static class Offer {

    private long id;
    private OfferType type;

    public Offer(long id, OfferType type) {
      this.id = id;
      this.type = type;
    }

    public long getId() {
      return id;
    }

    public OfferType getType() {
      return type;
    }
  }

}
