package docs;


import docs.DocumentField.Field;
import docs.DocumentField.FieldBuilder;
import docs.DocumentField.FieldCollection;
import docs.DocumentField.FieldListBuilder;
import org.springframework.restdocs.payload.JsonFieldType;

public interface BaseDocumentFields {

	static Field string(String filedName) {
		return new FieldBuilder(filedName, JsonFieldType.STRING);
	}

	static Field string(String filedName, String desc, boolean isOptional) {
		return new FieldBuilder(filedName, JsonFieldType.STRING, desc, isOptional);
	}

	static Field string(String filedName, String desc) {
		return new FieldBuilder(filedName, JsonFieldType.STRING, desc);
	}

	static Field number(String filedName) {
		return new FieldBuilder(filedName, JsonFieldType.NUMBER);
	}

	static Field number(String filedName, String desc, boolean isOptional) {
		return new FieldBuilder(filedName, JsonFieldType.NUMBER, desc, isOptional);
	}

	static Field number(String filedName, String desc) {
		return new FieldBuilder(filedName, JsonFieldType.NUMBER, desc);
	}

	static FieldCollection object(String filedName) {
		return new FieldListBuilder(filedName, JsonFieldType.OBJECT);
	}

	static FieldCollection object(String filedName, String desc, boolean isOptional) {
		return new FieldListBuilder(filedName, JsonFieldType.OBJECT, desc, isOptional);
	}

	static FieldCollection object(String filedName, String desc) {
		return new FieldListBuilder(filedName, JsonFieldType.OBJECT, desc);
	}

	static FieldCollection list(String filedName) {
		return new FieldListBuilder(filedName, JsonFieldType.ARRAY);
	}

	static FieldCollection list(String filedName, String desc, boolean isOptional) {
		return new FieldListBuilder(filedName, JsonFieldType.ARRAY, desc, isOptional);
	}

	static FieldCollection list(String filedName, String desc) {
		return new FieldListBuilder(filedName, JsonFieldType.ARRAY, desc);
	}

	static Field bool(String filedName) {
		return new FieldBuilder(filedName, JsonFieldType.BOOLEAN);
	}

	static Field bool(String filedName, String desc, boolean isOptional) {
		return new FieldBuilder(filedName, JsonFieldType.BOOLEAN, desc, isOptional);
	}

	static Field bool(String filedName, String desc) {
		return new FieldBuilder(filedName, JsonFieldType.BOOLEAN, desc);
	}

	static Field empty(String filedName) {
		return new FieldBuilder(filedName, JsonFieldType.NULL);
	}

	static Field empty(String filedName, String desc) {
		return new FieldBuilder(filedName, JsonFieldType.NULL, desc);
	}

	static Field empty(String filedName, String desc, boolean isOptional) {
		return new FieldBuilder(filedName, JsonFieldType.NULL, desc, isOptional);
	}
}
