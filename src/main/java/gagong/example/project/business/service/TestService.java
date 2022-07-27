package gagong.example.project.business.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gagong.example.project.business.repository.entity.TestEntity;
import gagong.example.project.business.repository.repository.TestRepository;

@Service
public class TestService {

	private final TestRepository testRepository;

	private static final String ENTITY_NOT_FOUND_BY_ID_ERROR = "Entity with given id = %s not found";

	private static final String ENTITY_NOT_FOUND_BY_STRING_FIELD_ERROR = "Entity with given stringField = %s not found";

	public TestService(final TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	public TestEntity create(final String stringField, final boolean booleanField) {
		return testRepository.save(
				TestEntity.builder()
						.stringField(stringField)
						.booleanField(booleanField)
						.build()
		);
	}

	@Transactional
	public void update(final Long id, final String stringField, final boolean booleanField) {
		testRepository.findById(id).ifPresentOrElse(
				entity -> {
					entity.setStringField(stringField);
					entity.setBooleanField(booleanField);
				}, () -> {
					throw new RuntimeException(String.format(ENTITY_NOT_FOUND_BY_ID_ERROR, id));
				});
	}

	public void delete(final Long id) {
		if (testRepository.existsById(id)) {
			testRepository.deleteById(id);
		} else {
			throw new RuntimeException(String.format(ENTITY_NOT_FOUND_BY_ID_ERROR, id));
		}
	}

	public TestEntity findByStringField(final String stringField) {
		return Optional.ofNullable(testRepository.findByStringField(stringField)).orElseThrow(() -> new RuntimeException(String.format(ENTITY_NOT_FOUND_BY_STRING_FIELD_ERROR, stringField)));
	}

}
