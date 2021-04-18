package com.details.NACE.model;

import java.util.List;
import lombok.Data;

@Data
public class ItemAlsoIncludes {

	private String foodItemAlsoIncludeDesc;

	private List<String> foodItemsAlsoInclSubList;
}
