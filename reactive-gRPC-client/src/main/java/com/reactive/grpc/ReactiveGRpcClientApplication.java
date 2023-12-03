package com.reactive.grpc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Couchbase Reactive GRPC Application", version = "1.0", description = "Couchbase Reactive GRPC Application"))
public class ReactiveGRpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveGRpcClientApplication.class, args);
	}

}
