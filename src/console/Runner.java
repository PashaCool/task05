package console;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import entity.Tour;
import exceptions.ServiceException;
import service.FactoryException;
import service.ServiceFactory;
import service.TourService;
import service.logic.MainServiceFactoryImpl;

public class Runner {

	public static void main(String[] args) {
		
		List<Tour> tours = new ArrayList<Tour>();
        try {
            ServiceFactory fact = new MainServiceFactoryImpl();
            TourService service = fact.getTourService();
            tours = service.readAllTour();
            
        } catch (FactoryException | ServiceException e) {
            e.printStackTrace();
        }
	}
}
