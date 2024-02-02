package docs;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class BaseController {


	@GetMapping
	public ResponseEntity<BaseResponse> get(BaseRequest baseRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setName("sampleName + :" + baseRequest);
		return ResponseEntity.ok(baseResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse> get(@PathVariable String id) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setName("sampleName 단건조회: " + id);
		return ResponseEntity.ok(baseResponse);
	}

	@GetMapping("/search")
	public ResponseEntity<List<BaseResponse>> search(BaseRequest baseRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setName(baseRequest.getName());
		return ResponseEntity.ok(List.of(baseResponse));
	}

	@PostMapping
	public ResponseEntity<BaseResponse> post(@RequestBody BaseRequest baseRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setName(baseRequest.getName());
		return ResponseEntity.created(URI.create("sample")).body(baseResponse);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<BaseResponse> patch(@PathVariable String id, @RequestBody BaseRequest baseRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setName("sampleName : " + id);
		return ResponseEntity.ok(baseResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return ResponseEntity.noContent().build();
	}


	static class BaseResponse {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class BaseRequest {

		private String name;
		private String sortType;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSortType() {
			return sortType;
		}

		public void setSortType(String sortType) {
			this.sortType = sortType;
		}
	}
}
