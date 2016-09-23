package steps;

import model.AgendarPages;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;


/**
 * Created by afranco7 on 21/09/2016.
 */

public class AgendarCitas extends Steps{
    private AgendarPages agendarPages =new AgendarPages();

    @Given("I am at the main page of the system")
    public void goToMainPage(){
        agendarPages.goToMainPage("http://automatizacion.herokuapp.com/afranco/");
    }

    @Given("I am at the main page of the system in chrome")
    public void goToMainPageInChrome(){
        agendarPages.goToMainPageInChrome("http://automatizacion.herokuapp.com/afranco/");
    }


    @When("I select the Agregar $DoctorPatient Option")
    public void selectAgregarDoctor(@Named("DoctorPatient") String doctor){
        agendarPages.selectAgregarDoctorPatient(doctor);
    }

    @When("I select the Agendar $Cita Option")
    public void selectAgendarCita(@Named("Cita") String cita){
        agendarPages.selectAgregarDoctorPatient(cita);
    }

    @Then("I validate that i am in the add $doctorPatient page")
    public void verifyTheCorrectPage(@Named("doctorPatient") String doctorPatient){
        agendarPages.verifyTheCorrectPage(doctorPatient);
    }

    @When("I fill all the inputs of the form")
    public void fillTheAddADoctorForm(){
        agendarPages.fillTheAddADoctorForm();
    }

    @When("I click on Guardar button")
    public void clickOnGuardar(){
        agendarPages.clickOnGuardar();
    }

    @Then("I validate that the $doctorPatient is correctly added")
    public void verifyThatDoctorPatientIsAdded(){
        agendarPages.verifyThatDoctorPatientIsAdded();
    }

    @When("I fill all the inputs of the patient form")
    public void fillAddAPatientForm(){
        agendarPages.fillAddAPatientForm();
    }

    @When("I fill all the inputs of the AgendarCitas form")
    public void fillAgendarCitasForm(){
        agendarPages.fillAgendarCitasForm();
    }

    @Then("I verify that the appointment is correctly added")
    public void verifyAppointmentAdded(){
        agendarPages.verifyAppointmentAdded();
    }
}
