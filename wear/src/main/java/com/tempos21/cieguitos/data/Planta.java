package com.tempos21.cieguitos.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernat on 24/10/2014.
 */
public class Planta {
	private List<Expo> expos = new ArrayList<Expo>();

	public Planta() {
		expos = new ArrayList<Expo>();
		expos.add(new Expo());
		expos.add(new Expo());
		expos.add(new Expo());
		expos.add(new Expo());
	}

	public List<Expo> getExpos() {
		return expos;
	}

	public void setExpos(List<Expo> expos) {
		this.expos = expos;
	}
}
