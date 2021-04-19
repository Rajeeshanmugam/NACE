package com.details.NACE.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.details.NACE.exception.NotFoundException;
import com.details.NACE.model.FoodItem;
import com.details.NACE.model.ItemAlsoIncludes;
import com.details.NACE.model.ItemExclude;
import com.details.NACE.model.ItemIncludes;
import com.details.NACE.model.NaceDetailsDTO;

@RunWith(MockitoJUnitRunner.class)
public class NaceRepositoryTest {

	@Mock
	private NaceRepository naceRepository;

	private NaceDetailsDTO nacedetailsDto;

	@Before
	public void intialSetup() {

		List<String> typeofGrowingsubList = new ArrayList<String>();
		typeofGrowingsubList.add("wheat");
		typeofGrowingsubList.add("grain maize");
		typeofGrowingsubList.add("sorghum");

		FoodItem foodItemOne = new FoodItem();
		foodItemOne.setTypeofGrowing("- growing of cereals such as:");
		foodItemOne.setTypeofGrowingsubList(typeofGrowingsubList);

		FoodItem foodItemTwo = new FoodItem();
		foodItemTwo.setTypeofGrowing("- growing of cereals such as:");
		foodItemTwo.setTypeofGrowingsubList(typeofGrowingsubList);

		List<FoodItem> fooditemList = new ArrayList<FoodItem>();
		fooditemList.add(foodItemOne);
		fooditemList.add(foodItemTwo);

		ItemIncludes itemIncludes = new ItemIncludes();
		itemIncludes.setFoodIncludeItemDesc(
				"This class includes all forms of growing of cereals, leguminous crops and oil seeds in open fields. The growing of these crops is often combined within agricultural units.");
		itemIncludes.setFoodItems(fooditemList);

		List<String> foodItemsAlsoInclSubList = new ArrayList<String>();
		foodItemsAlsoInclSubList.add("activities of farriers");
		foodItemsAlsoInclSubList.add("provision of agricultural machinery with operators and crew");

		ItemAlsoIncludes itemAlsoInclude = new ItemAlsoIncludes();
		itemAlsoInclude.setFoodItemAlsoIncludeDesc(
				"Also included are post-harvest crop activities, aimed at preparing agricultural products for the primary market.");
		itemAlsoInclude.setFoodItemsAlsoInclSubList(foodItemsAlsoInclSubList);

		List<String> rulings = new ArrayList<String>();
		rulings.add("Nurturing and selling of tree seedlings");
		rulings.add("Nurturing of tree seedlings");

		List<String> damageitemList = new ArrayList<String>();
		damageitemList.add("growing of rice, see 01.12");
		damageitemList.add("growing of sweet corn, see 01.13");
		damageitemList.add("growing of maize for fodder, see 01.19");
		damageitemList.add("growing of oleaginous fruits, see 01.26");

		ItemExclude itemExclude = new ItemExclude();
		itemExclude.setItemExcludeDesc("Item Excludes due to damage");
		itemExclude.setExcludeItemList(damageitemList);

		nacedetailsDto = new NaceDetailsDTO();
		nacedetailsDto.setOrder(123456);
		nacedetailsDto.setLevel(3);
		nacedetailsDto.setCode("A");
		nacedetailsDto.setParent("1.1");
		nacedetailsDto.setDescription("Growing of cereals (except rice), leguminous crops and oil seeds");
		nacedetailsDto.setItemInclude(itemIncludes);
		nacedetailsDto.setItemAlsoInclude(itemAlsoInclude);
		nacedetailsDto.setRulings(rulings);
		nacedetailsDto.setItemExclude(itemExclude);
		nacedetailsDto.setReferenceToISIC("567");
	}

	@Test
	public void test_create() throws IOException {
		NaceDetailsDTO createdDto = naceRepository.save(nacedetailsDto);
		assertNotNull(createdDto);
		assertEquals(nacedetailsDto.getCode(), createdDto.getCode());
	}

	@Test
	public void test_getDetails() throws NotFoundException {
		Optional<NaceDetailsDTO> returnedDto = naceRepository.findByOrder(398484);
		assertNotNull(returnedDto);
	}
}
