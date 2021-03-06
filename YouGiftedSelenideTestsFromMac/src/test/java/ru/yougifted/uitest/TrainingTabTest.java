package ru.yougifted.uitest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.PreconditionTestNG;

import java.util.Date;

public class TrainingTabTest extends PreconditionTestNG {

    @Test
    public void testName() throws Exception {


        String varName = "Александр";
        String varSurname = "Владимиров";
        String varPhone = "+79997777777";
        String varMail = new Date().getTime() + "@csc.csc";

        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();

        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(
                varName, varSurname, varMail, varPhone);



        System.out.println("\nCheck that Done button is red");


        Assert.assertTrue(tabTraining.checkColorButtonDoneRedAndEnableToPushOnTabTraining()
                .shouldBe(Condition.visible)
                        .exists()
                ,"Red button does not found");


        tabTraining.buttonDoneTabTrainingClick();

        Selenide.refresh();

        System.out.println("\nReload page");

        System.out.println("\nCheck that text 'You have done this exercise' is exist on page");

        Assert.assertTrue(tabTraining.checkTextYouHaveDoneThisTraining()
                .exists());

        System.out.println("\nCheck text under grey button that today you have already finished your exercises");

        System.out.println("\nText under grey button is:\n" + tabTraining.tabTrainingTextTodayYouAreCompletedYourTraining());

//        Assert.assertTrue(tabTraining.tabTrainingTextTodayYouAreCompletedYourTraining());


    }

}
