package model;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by afranco7 on 21/09/2016.
 */
public class DoctorPage {

    public WebDriver driver;

    private static final By LIST_MENU_OPTIONS = By.cssSelector(".list-group-item");
    private static final By NAME_DOCTOR = By.cssSelector("input#name.form-control");
    private static final By LAST_NAME_DOCTOR = By.cssSelector("input#last_name.form-control");
    private static final By TELEPHONE_DOCTOR = By.cssSelector("input#telephone.form-control");
    private static final By IDENTIFICATION_TYPE_DOCTOR = By.cssSelector("select#identification_type.form-control");
    private static final By IDENTIFICATION_DOCTOR = By.cssSelector("input#identification.form-control");
    private static final By GUARDAR_BUTTON = By.cssSelector("a.btn.btn-primary.pull-right");
    private static final By SUCCESS_SAVED = By.cssSelector("div.panel-body");
    private static int CEDULA=0;

    public void goToMainPage(String url){
        driver = new FirefoxDriver();
        driver.get(url);
    }

    public void selectAgregarDoctorPatient(String doctorPatient){
        List<WebElement> menuOptions = driver.findElements(LIST_MENU_OPTIONS);

        if(doctorPatient.trim().equalsIgnoreCase("Doctor")) {
            //clickeamos en el primer elemento de la lista por que es la opcion de agregar doctor
            menuOptions.get(0).click();
        } else if(doctorPatient.trim().equalsIgnoreCase("Paciente")) {
            menuOptions.get(1).click();
        } else {
            throw new WebDriverException("Invalid parameter " + doctorPatient );
        }
    }

    public void verifyTheCorrectPage(String doctorPatient){
        if(doctorPatient.trim().equalsIgnoreCase("doctor")) {
            Assert.assertEquals("No es la pagina correcta",driver.getCurrentUrl(),"http://automatizacion.herokuapp.com/afranco/addDoctor");
        } else if(doctorPatient.trim().equalsIgnoreCase("patient")) {
            Assert.assertEquals("No es la pagina correcta",driver.getCurrentUrl(),"http://automatizacion.herokuapp.com/afranco/addPatient");
        } else {
            throw new WebDriverException("Invalid parameter " + doctorPatient );
        }


    }

    public void fillTheAddADoctorForm(){
        driver.findElement(NAME_DOCTOR).sendKeys("ELIANA");
        driver.findElement(LAST_NAME_DOCTOR).sendKeys("MENDEZ");
        driver.findElement(TELEPHONE_DOCTOR).sendKeys("3017500584");
        driver.findElement(IDENTIFICATION_TYPE_DOCTOR);
        Select select = new Select(driver.findElement(IDENTIFICATION_TYPE_DOCTOR));
        select.selectByIndex(CEDULA);
        driver.findElement(IDENTIFICATION_DOCTOR).sendKeys("999999999");
    }

    public void clickOnGuardar(){
        driver.findElement(GUARDAR_BUTTON).click();
    }

    public void verifyThatDoctorIsAdded(){
        boolean goodMessage=false;
        String alreadySavedMessage="No se pudo guardar debido a:\n" +
                "*El campo 'Documento de identidad' ya esta registrado.";
        String correctlySavedMessage="Datos guardados correctamente.";
        String currentMessage = driver.findElement(SUCCESS_SAVED).getText().trim();

        if (!currentMessage.equalsIgnoreCase(alreadySavedMessage)){
            goodMessage=true;
        }else if(!currentMessage.equalsIgnoreCase(correctlySavedMessage)){
            goodMessage=true;
        }

        if (!goodMessage){
            throw new WebDriverException("Ocurrio un error con el doctor a guardar" + currentMessage );
        }
        driver.close();
    }

}
