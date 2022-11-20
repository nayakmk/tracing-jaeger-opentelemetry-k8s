package io.nayakmk.samples.tracing.config;

import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;

@org.springframework.context.annotation.Configuration
public class SamplerConfig {
    
    @Bean
	public io.opentracing.Tracer initTracer() {
		SamplerConfiguration samplerConfig = new SamplerConfiguration().withType("const").withParam(1);
		ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true);
		return Configuration.fromEnv("library-service").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}
}
