package gagong.example.project.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Ипользовать {@link lombok.Data} в {@link Entity} запрещено
 * {@link lombok.ToString} вызывает все поля, которые могут содержать PersistenceSet(Collection)
 * Коллекция в свою очередь может иметь {@link javax.persistence.FetchType} = LAZY
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "test_entity")
public class TestEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String stringField;

	@Builder.Default
	@Column(nullable = false)
	private Boolean booleanField = Boolean.FALSE;


}
