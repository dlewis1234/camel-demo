package com.example.demo.component;



import java.util.Iterator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.ZipFileDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:camel.properties")
public class CamelRoutes extends RouteBuilder {
	
	@Value("${camel.filePath}")
	private String filePath;
	
	@Autowired
	SftpProcessor sftpProcessor;
	
	@Autowired
	DataProcessor dataProcessor;
	
	@Autowired
	ValidationProcessor validationProcessor;
	
	@Autowired
	SplitProcessor splitProcessor;
	
	@Autowired
	RecordProcessor recordProcessor;

	@Override
	public void configure() throws Exception {

		ZipFileDataFormat zf = new ZipFileDataFormat();
		zf.setUsingIterator(true);

		from("file:" + filePath + "/sftp")
			.id("sftpFiles").process(sftpProcessor).unmarshal(zf).split(bodyAs(Iterator.class)).streaming()
				.to("file:" + filePath + "/zip");
		
		from("file:" + filePath +"/zip/?antInclude=**/DDM*")
			.id("unzipDataFiles").process(dataProcessor).unmarshal(zf).split(bodyAs(Iterator.class)).streaming()
			.to("file:" + filePath + "/unzip");
		
		from("file:" + filePath +"/zip/?antInclude=**/BDM*,**/RDM*")
			.id("verifyFile").doTry().process(validationProcessor).to("direct:splitFile").doCatch(Exception.class).doFinally().end();
		
		from("direct:splitFile")
			.id("splitFile").process(splitProcessor).split(xpath("//n:Case").namespace("n","http://www.visa.com/ROLSI"))
			.to("direct:processRecord");
		
		from("direct:processRecord")
			.id("processRecord").threads(5).process(recordProcessor).end();

	}

}
