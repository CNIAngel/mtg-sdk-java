package io.magicthegathering.javasdk.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import io.magicthegathering.javasdk.resource.Card;

import java.nio.file.Path;
import java.util.List;

import org.junit.Test;

import by.stub.client.StubbyClient;

public class CardAPITest extends MTGAPITest {

	@Test
	public void testGetCard() {
		Card testCard = new Card();
		testCard.setMultiverseid(1);
		assertEquals(testCard, CardAPI.getCard(1));
		assertFalse(testCard.equals(CardAPI.getCard(10)));
	}

	@Test
	public void testBadCardId() throws Exception {
		assertNull(CardAPI.getCard(-1));
	}

	@Test
	public void testGetAll() throws Exception {
		List<Card> testCardList = CardAPI.getAllCards();
		Card testCard = new Card();
		testCard.setMultiverseid(94);
		assertEquals(testCardList.get(0), testCard);
	}

	@Test
	public void testGetAllCardTypes() throws Exception {
		//TODO Remove when supported with stubby
		teardownStubby();
		List<String> types = CardAPI.getAllCardTypes();
		assertTrue(types.contains("Artifact"));
		assertTrue(types.contains("Creature"));
		assertTrue(types.contains("Planeswalker"));
	}
}
