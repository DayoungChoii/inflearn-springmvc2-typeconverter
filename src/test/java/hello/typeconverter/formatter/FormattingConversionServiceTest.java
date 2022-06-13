package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpToStringConverter;
import hello.typeconverter.converter.StringToIpConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattringConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addConverter(new StringToIpConverter());
        conversionService.addConverter(new IpToStringConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Integer.class)).isEqualTo(1000L);
    }
}
