package com.details.NACE.model;


import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "naceDetails")
public class NaceDetailsDTO {

	@Indexed(name = "order", unique = true)
	private int order;

	private int level;

	private String code;

	private String parent;

	private String description;

	private ItemIncludes itemInclude;

	private ItemAlsoIncludes itemAlsoInclude;

	private List<String> rulings;

	private ItemExclude itemExclude;

	private String referenceToISIC;

}
