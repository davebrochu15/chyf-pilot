package net.refractions.chyf.hygraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.refractions.chyf.enumTypes.CatchmentType;
import net.refractions.chyf.indexing.SpatiallyIndexable;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class ECatchment implements SpatiallyIndexable {
	private final int id;
	private final double area;
	private final Polygon polygon;
	private CatchmentType type;
	private boolean terminal;
	private int rank = -1;
	private String name = null;
	private int strahlerOrder = -1;
	private int hortonOrder = -1;
	//private int hackOrder = -1;
	private List<EFlowpath> flowpaths;
	private List<Nexus> upNexuses; 
	private List<Nexus> downNexuses; 
	
	public ECatchment(int id, CatchmentType type, Polygon polygon) {
		this.id = id;
		this.type = type;
		this.polygon = polygon;
		this.area = polygon.getArea();
		this.flowpaths = new ArrayList<EFlowpath>(1);
		this.upNexuses = new ArrayList<Nexus>(1);
		this.downNexuses = new ArrayList<Nexus>(1);
	}
	
	public int getId() {
		return id;
	}

	public double getArea() {
		return area;
	}

	public CatchmentType getType() {
		return type;
	}

	public void setType(CatchmentType type) {
		this.type = type;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	public int getRank() {
		return rank;
	}

	public String getName() {
		return name;
	}

	public int getStrahlerOrder() {
		return strahlerOrder;
	}

	public void setStrahlerOrder(int strahlerOrder) {
		this.strahlerOrder = strahlerOrder;
	}

	public int getHortonOrder() {
		return hortonOrder;
	}

	public void setHortonOrder(int hortonOrder) {
		this.hortonOrder = hortonOrder;
	}

//	public int getHackOrder() {
//		return hackOrder;
//	}
//
//	public void setHackOrder(int hackOrder) {
//		this.hackOrder = hackOrder;
//	}

	public Polygon getPolygon() {
		return polygon;
	}

	@Override
	public Envelope getEnvelope() {
		return polygon.getEnvelopeInternal();
	}
	
	@Override
	public double distance(Point p) {
		return polygon.distance(p);
	}

	public void addFlowpath(EFlowpath flowpath) {
		if(flowpath.getRank() > 0 
				&& (rank < 0 || (flowpath.getRank() < rank))) {
			rank = flowpath.getRank();
		}
		if(flowpath.getStrahlerOrder() > strahlerOrder) {
			strahlerOrder = flowpath.getStrahlerOrder();
		}
		if(flowpath.getHortonOrder() > hortonOrder) {
			hortonOrder = flowpath.getHortonOrder();
		}
//		if(flowpath.getHackOrder() < hackOrder) {
//			hackOrder = flowpath.getHackOrder();
//		}
		if(flowpath.getName() != null && !flowpath.getName().isEmpty()) {
			if(name == null) {
				name = flowpath.getName();
			} else if(!name.equals(flowpath.getName())) {
				// empty string is a special value to mean we aren't going to assign a name 
				// because flowpaths with different names are contained by this eCatchment
				name = ""; 
			}
		}
		flowpaths.add(flowpath);
	}

	public List<EFlowpath> getFlowpaths() {
		return Collections.unmodifiableList(flowpaths);
	}	

	public void addUpNexus(Nexus nexus) {
		upNexuses.add(nexus);
	}

	public void addDownNexus(Nexus nexus) {
		downNexuses.add(nexus);
	}
	
	public List<Nexus> getUpNexuses() {
		return Collections.unmodifiableList(upNexuses);
	}

	public List<Nexus> getDownNexuses() {
		return Collections.unmodifiableList(downNexuses);
	}
	
}
