package nl.jaapcoomans.demo.springbootmodules.boardgame.bgg;

import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.Items;

import feign.Param;
import feign.RequestLine;

public interface BoardGameGeekClient {
	@RequestLine("GET /thing?id={id}&type=boardgame&stats=1")
	Items getItemsWithRating(@Param("id") int id);
}
