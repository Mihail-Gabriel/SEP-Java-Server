package com.sep.SepJavaServer;

import com.sep.SepDataServer.MessagesServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class SepJavaServerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SepJavaServerApplication.class, args);

		MessagesServer server=new MessagesServer();
		server.start(4444);
		System.out.println("Server started...");
	}

}
