package docs.builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FieldCollection implements Fields {

    private final Field field;
    private final Set<Field> fields = new HashSet<>();

    public FieldCollection(Field field) {
        this.field = field;
    }

    @Override
    public Fields desc(String desc) {
        this.field.desc(desc);
        return this;
    }

    @Override
    public Fields optional() {
        this.field.optional();
        return this;
    }

    @Override
    public FieldGetter toGetFiled() {
        return field.toGetFiled();
    }

    @Override
    public Fields with(Field... fields) {
        final var list = Arrays
            .stream(fields)
            .map(field -> {
                final var rootField = this.field.toGetFiled();
                final var rootName = rootField.getFieldName();

                final var subField = field.toGetFiled();
                final var subFieldName = subField.getFieldName();

                return new FieldDefault(String.format("%s[].%s", rootName, subFieldName),
                    subField.getJsonDocumentFieldType(),
                    subField.getDesc(),
                    subField.isOptional());
            })
            .toList();

        this.fields.addAll(list);
        return this;
    }

    @Override
    public List<Field> getFields() {
        return this.fields
            .stream()
            .toList();
    }

    @Override
    public Field getRootField() {
        return this.field;
    }
}
