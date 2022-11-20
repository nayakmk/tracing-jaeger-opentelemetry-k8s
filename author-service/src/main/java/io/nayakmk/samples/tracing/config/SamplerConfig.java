package io.nayakmk.samples.tracing.config;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class SamplerConfig {
    
    @Bean
	public io.opentracing.Tracer initTracer() {
		SamplerConfiguration samplerConfig = new SamplerConfiguration().withType("const").withParam(1);
		ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true);
		return Configuration.fromEnv("author-service").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}
}
