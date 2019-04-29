package nl.jaapcoomans.boardgame.bgg;

import nl.jaapcoomans.boardgame.bgg.xmlapi.Items;

import feign.Param;
import feign.RequestLine;

public interface BoardGameGeekClient {
	@RequestLine("GET /thing?id={id}&type=boardgame&stats=1")
	Items getItemsWithRating(@Param("id") int id);
}
