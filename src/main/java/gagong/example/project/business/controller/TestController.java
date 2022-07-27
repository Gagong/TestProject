package gagong.example.project.business.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gagong.example.project.business.repository.entity.TestEntity;
import gagong.example.project.business.service.TestService;

@RestController
@RequestMapping
public class TestController {

	private final TestService testService;

	public TestController(final TestService testService) {
		this.testService = testService;
	}

	@GetMapping
	public ResponseEntity<TestEntity> getEntityByStringField(@RequestParam String stringField) {
		try {
			return ResponseEntity.ok(testService.findByStringField(stringField));
		} catch (final Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping
	public ResponseEntity update(@RequestParam Long id, @RequestParam String stringField, @RequestParam boolean booleanField) {
		try {
			testService.update(id, stringField, booleanField);
			return ResponseEntity.ok().build();
		} catch (final Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping
	public ResponseEntity create(@RequestParam String stringField, @RequestParam boolean booleanField) {
		try {
			testService.create(stringField, booleanField);
			return ResponseEntity.ok().build();
		} catch (final Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping
	public ResponseEntity delete(@RequestParam Long id) {
		try {
			testService.delete(id);
			return ResponseEntity.ok().build();
		} catch (final Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
