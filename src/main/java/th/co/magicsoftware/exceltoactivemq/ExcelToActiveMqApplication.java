package th.co.magicsoftware.exceltoactivemq;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ExcelToActiveMqApplication {

	public static void main(String[] args) throws OpenXML4JException, IOException, InterruptedException {
		SpringApplication.run(ExcelToActiveMqApplication.class, args);

	}

}
