package com.details.NACE.model;

import java.util.List;
import lombok.Data;

@Data
public class ItemIncludes {

	private String foodIncludeItemDesc;

	private List<FoodItem> foodItems;
}
