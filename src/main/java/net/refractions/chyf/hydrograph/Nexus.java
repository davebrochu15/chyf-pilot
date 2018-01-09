package net.refractions.chyf.hydrograph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vividsolutions.jts.geom.Point;

public class Nexus {
	private ArrayList<EFlowpath> upFlows = new ArrayList<EFlowpath>();
	private ArrayList<EFlowpath> downFlows = new ArrayList<EFlowpath>();
	private Point point;
	private double distance;

	public Nexus(Point point) {
		this.point = point;
		distance = -1;
	}

	public void addUpFlow(EFlowpath edge) {
		upFlows.add(edge);
	}

	public void addDownFlow(EFlowpath edge) {
		downFlows.add(edge);
	}

	public List<EFlowpath> getUpFlows(){
		return Collections.unmodifiableList(upFlows);
	}

	public List<EFlowpath> getDownFlows() {
		return Collections.unmodifiableList(downFlows);
	}

	public Point getPoint() {
		return point;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}