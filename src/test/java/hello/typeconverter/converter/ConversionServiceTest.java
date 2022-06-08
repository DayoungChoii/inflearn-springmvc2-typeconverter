package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {

        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new StringToIpConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpToStringConverter());

        //사용
        assertThat(conversionService.convert("10", Integer.class));
        assertThat(conversionService.convert(10, String.class));

        String ipPortStr = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortStr).isEqualTo("127.0.0.1:8080");
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));


    }
}
