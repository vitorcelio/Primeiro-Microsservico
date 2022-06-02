package com.ms.payroll.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;

@Configuration
public class CircuitBreakerConfig {
	
	private final Logger logger = LoggerFactory.getLogger(CircuitBreakerConfig.class);
	
	@Bean
	public RegistryEventConsumer<CircuitBreaker> paymentFallback(){
		return new RegistryEventConsumer<CircuitBreaker>() {

			@Override
			public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
				// TODO Auto-generated method stub
				entryAddedEvent.getAddedEntry()
								.getEventPublisher()
								.onStateTransition(event ->{
									logger.info(event.toString());
								});
			}

			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
}
