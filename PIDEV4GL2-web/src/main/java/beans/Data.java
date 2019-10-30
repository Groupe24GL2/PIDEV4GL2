package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.Category;
import entities.TypeEvaluation;

@ManagedBean
@ApplicationScoped
public class Data {

	public TypeEvaluation[] getEvalTypes() {
		return TypeEvaluation.values();
	}

	public Category[] getCategories() {
		return Category.values();
	}

}