package com.projeto.rest.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Problema implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long staus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "MGT")
	private Instant tempo;
	
	private String  mensagem;
	
	private String path;
	
	public Problema() {}

	public Problema(Long staus, Instant tempo, String msg, String path) {
		super();
		this.staus = staus;
		this.tempo = tempo;
		this.mensagem = msg;
		this.path = path;
	}

	
	public Long getStaus() {
		return staus;
	}

	public void setStaus(Long staus) {
		this.staus = staus;
	}

	public Instant getTempo() {
		return tempo;
	}

	public void setTempo(Instant tempo) {
		this.tempo = tempo;
	}

	public String getMsg() {
		return mensagem;
	}

	public void setMsg(String msg) {
		this.mensagem = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
