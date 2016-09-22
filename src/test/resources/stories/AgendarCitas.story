AgendarCitas

Meta:
@suite citas

Narrative:
As an anonymous user
I want to add a new doctor in the database
So that I can validate that the doctor is correctly added

Scenario: Adding a new doctor in the system

Given I am at the main page of the system
When I select the Agregar Doctor Option
Then I validate that i am in the add doctor page
When I fill all the inputs of the form
And I click on Guardar button
Then I validate that the doctor is correctly added

Scenario: Adding a new patient in the system

Given I am at the main page of the system
When I select the Agregar Paciente Option
Then I validate that i am in the add patient page
When I fill all the inputs of the patient form
And I click on Guardar button
Then I validate that the patient is correctly added

Scenario: creating a new appointment

Given I am at the main page of the system
When I select the Agendar Cita Option
Then I validate that i am in the add Cita page
When I fill all the inputs of the AgendarCitas form
And I click on Guardar button
Then I verify that the appointment is correctly added