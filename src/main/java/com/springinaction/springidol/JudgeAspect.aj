package com.springinaction.springidol;

public aspect JudgeAspect {
	public JudgeAspect() {
	}

	pointcut performance() : call(* perform(..));

	after() returning() : performance() {
		System.out.println("asdfgasdfasd");//criticismEngine.getCriticism());
	}

	// внедряется
	private CriticismEngine criticismEngine;

	public void setCriticismEngine(CriticismEngine criticismEngine) {
		this.criticismEngine = criticismEngine;
	}
}
