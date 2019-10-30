package beans;

import java.io.Serializable;
import org.primefaces.model.chart.PieChartModel;

import serviceEvaluation.ServiceEvaluation;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="chartView")
public class ChartView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1 = new PieChartModel();
	private PieChartModel pieModel2;
	@EJB
	private ServiceEvaluation service;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		long res1 = service.getNombreAnnualJPQL();
		long res2 = service.getNombreBiAnnualJPQL();
		long res3 = service.getNombreQUARTERLYJPQL();
		long res5 = service.getPoureRequestJPQL();
		this.pieModel1.set("ANNUAL", res1 * 100 / res5);
		this.pieModel1.set("BIANNUAL", res2 * 100 / res5);
		this.pieModel1.set("QUARTERLY", res3 * 100 / res5);
		

		this.pieModel1.setTitle("Les Evaluation par Type En %");
		this.pieModel1.setLegendPosition("w");
		this.pieModel1.setShadow(false);
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();

	}

	private void createPieModel1() {

	
	}

	public void setPieModel1(PieChartModel pieModel1) {
		
		this.pieModel1 = pieModel1;
	}
	
}
