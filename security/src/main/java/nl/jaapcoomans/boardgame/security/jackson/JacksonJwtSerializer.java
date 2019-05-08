package nl.jaapcoomans.boardgame.security.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;

public class JacksonJwtSerializer<T> implements Serializer<T> {
	static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

	private final ObjectMapper objectMapper;

	public JacksonJwtSerializer() {
		this.objectMapper = DEFAULT_OBJECT_MAPPER;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		Assert.notNull(t, "Object to serialize cannot be null.");
		try {
			return this.objectMapper.writeValueAsBytes(t);
		} catch (JsonProcessingException e) {
			String msg = "Unable to serialize object: " + e.getMessage();
			throw new SerializationException(msg, e);
		}
	}
}
