package gagong.example.project.business.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gagong.example.project.business.repository.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

	TestEntity findByStringField(final String stringField);

}
