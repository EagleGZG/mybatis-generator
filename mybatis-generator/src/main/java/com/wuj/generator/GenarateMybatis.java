package com.wuj.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Created by wuj on 2018/1/15.
 */
public class GenarateMybatis {

    public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(
            GenarateMybatis.class.getResource("/generatorConfigWuJian.xml").getPath());
		System.out.print(configFile.exists());
		//
		// File configFile = new
		// File("D:\\workspace\\mybatis-genarate\\src\\genarate\\him-generate-mybatis.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("ok");
	}

}
