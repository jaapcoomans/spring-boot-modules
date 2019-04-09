package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.uri}")
	private String uri;

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(new MongoClientURI(uri));
	}

	@Bean
	@Override
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = Arrays.asList(
			new UUIDToStringConverter()
		);
		return new MongoCustomConversions(converterList);
	}

	@WritingConverter
	private static final class UUIDToStringConverter implements Converter<UUID, String> {
		@Override
		public String convert(final UUID uuid) {
			if (uuid == null) {
				return null;
			}
			return uuid.toString();
		}
	}
}