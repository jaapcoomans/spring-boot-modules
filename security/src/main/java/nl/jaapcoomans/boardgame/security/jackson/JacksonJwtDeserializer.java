package nl.jaapcoomans.boardgame.security.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;

public class JacksonJwtDeserializer<T> implements Deserializer<T> {
	private final Class<T> returnType;
	private final ObjectMapper objectMapper;

	public JacksonJwtDeserializer() {
		this(JacksonJwtSerializer.DEFAULT_OBJECT_MAPPER);
	}

	@SuppressWarnings({"unchecked", "WeakerAccess", "unused"}) // for end-users providing a custom ObjectMapper
	public JacksonJwtDeserializer(ObjectMapper objectMapper) {
		this(objectMapper, (Class<T>) Object.class);
	}

	private JacksonJwtDeserializer(ObjectMapper objectMapper, Class<T> returnType) {
		Assert.notNull(objectMapper, "ObjectMapper cannot be null.");
		Assert.notNull(returnType, "Return type cannot be null.");
		this.objectMapper = objectMapper;
		this.returnType = returnType;
	}

	@Override
	public T deserialize(byte[] bytes) throws DeserializationException {
		try {
			return objectMapper.readValue(bytes, returnType);
		} catch (IOException e) {
			String msg = "Unable to deserialize bytes into a " + returnType.getName() + " instance: " + e.getMessage();
			throw new DeserializationException(msg, e);
		}
	}
}
