package models.goal;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.common.base.Preconditions;

public class GoalModelAdapter {

	
	public GOALMODEL parseModel(File file) throws JAXBException {
		Preconditions.checkNotNull(file, "The file to be considered cannot be null");
		JAXBContext jaxbContext = JAXBContext.newInstance(GOALMODEL.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		GOALMODEL goalModel = (GOALMODEL) jaxbUnmarshaller.unmarshal(file);
		return goalModel;

	}
	
	public void writeGoalModel(File file, GOALMODEL goalModel) throws JAXBException{
		//Preconditions.checkNotNull(file, "The file to be considered cannot be null");
		Preconditions.checkNotNull(goalModel, "The goal model to be considered cannot be null");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(GOALMODEL.class);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(goalModel, file);
	}
}
