package main.model;

public class StateCensus {
	public String state;
    public int population;
    public int areaInSqKm;
    public int densityPerSqKm;
	public StateCensus(String state, int population, int areaInSqKm, int densityPerSqKm) {
		super();
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}
    
}
