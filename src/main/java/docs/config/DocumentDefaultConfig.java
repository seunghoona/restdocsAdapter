package docs.config;

import static docs.BaseDocumentFields.object;
import static docs.BaseDocumentFields.string;

import docs.docs.service.EndDocumentService;
import docs.docs.service.EndDocumentServiceImpl;
import java.beans.JavaBean;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class DocumentDefaultConfig implements DocumentConfig {

    @Override
    public DefaultResponse getResponseConfig() {

        final var headers = object("headers").desc("응답 헤더")
            .with(string("code", "응답 코드"))
            .with(string("message", "메시지"));

        return DefaultResponse
            .builder()
            .withField(headers)
            .wrapData(object("data").desc("데이터"))
            .build();
    }

}
