package com.gildedrose;

import static com.gildedrose.rule.ValidationRule.isWithInLimit;

public interface Goods {
	
	public void updateQuality(Item item);

	default void updateSellInDays(Item item) {
		item.sellIn--;
	}
	
	public void updateQualityForExpiredItem(Item item);
	
	default void addQualityWhenWithInLimit(Item item, int limit, int qualityToAdd) {
		if (isWithInLimit(limit, item.quality)) {
			item.quality = Math.min(limit, item.quality + qualityToAdd);
		}
	}
}
