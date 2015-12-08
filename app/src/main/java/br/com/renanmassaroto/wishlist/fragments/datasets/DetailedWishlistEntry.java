package br.com.renanmassaroto.wishlist.fragments.datasets;

import java.math.BigDecimal;

import br.com.renanmassaroto.wishlist.models.Category;

/**
 * Created by renan on 02/12/15.
 */
public class DetailedWishlistEntry {

    private Category mCategory;
    private BigDecimal mValue;

    public DetailedWishlistEntry(Category category, BigDecimal value) {
        this.mCategory = category;
        this.mValue = value;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category mCategory) {
        this.mCategory = mCategory;
    }

    public BigDecimal getValue() {
        return mValue;
    }

    public void setValue(BigDecimal mValue) {
        this.mValue = mValue;
    }
}
