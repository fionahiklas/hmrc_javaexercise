package com.hiklas.mucking.around;

/**
 * Implementation of a price list that counts items for offers
 */
public class DiscountPriceList implements PriceList {

  private PriceList actualPriceList;

  public DiscountPriceList(PriceList actualPriceList) {
    this.actualPriceList = actualPriceList;
  }

  public ItemPrice getItemPrice(long id) {
    return actualPriceList.getItemPrice(id);
  }

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
