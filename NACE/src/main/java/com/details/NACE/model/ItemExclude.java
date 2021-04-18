package com.details.NACE.model;

import java.util.List;
import lombok.Data;

@Data
public class ItemExclude {

	private String itemExcludeDesc;

	private List<String> excludeItemList;
}
