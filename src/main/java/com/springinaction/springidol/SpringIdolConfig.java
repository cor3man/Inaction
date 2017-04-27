package com.springinaction.springidol;

import org.springframework.context.annotation.*;

@Configuration
public class SpringIdolConfig {
	// Здесь находятся методы, определяющие компоненты
	@Bean
	public Performer duke() {
		return new Juggler();
	}
}