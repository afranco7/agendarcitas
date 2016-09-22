package steps;

import model.DoctorPage;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;


/**
 * Created by afranco7 on 21/09/2016.
 */

public class AgendarCitas extends Steps{
    private DoctorPage doctorPage=new DoctorPage();


    @Given("I am at the main page of the system")
    public void goToMainPage(){
        doctorPage.goToMainPage("http://automatizacion.herokuapp.com/afranco/");
    }

    @When("I select the Agregar $DoctorPatient Option")
    public void selectAgregarDoctor(@Named("DoctorPatient") String doctor){
        doctorPage.selectAgregarDoctorPatient(doctor);
    }

    @Then("I validate that i am in the add $doctorPatient page")
    public void verifyTheCorrectPage(@Named("doctorPatient") String doctorPatient){
        doctorPage.verifyTheCorrectPage(doctorPatient);
    }

    @When("I fill all the inputs of the form")
    public void fillTheAddADoctorForm(){
        doctorPage.fillTheAddADoctorForm();
    }

    @When("I click on Guardar button")
    public void clickOnGuardar(){
        doctorPage.clickOnGuardar();
    }

    @Then("I validate that the doctor is correctly added")
    public void verifyThatDoctorIsAdded(){
        doctorPage.verifyThatDoctorIsAdded();
    }

}
