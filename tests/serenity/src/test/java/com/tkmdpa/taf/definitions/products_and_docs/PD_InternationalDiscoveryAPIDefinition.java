package com.tkmdpa.taf.definitions.products_and_docs;

import com.tkmdpa.taf.definitions.site.CommonDefinition;
import com.tkmdpa.taf.steps.pantheon.UserAccountSteps;
import com.tkmdpa.taf.steps.pantheon.UserLogInSteps;
import com.tkmdpa.taf.steps.products_and_docs.PD_InternationalDiscoveryAPISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static net.serenitybdd.core.Serenity.getCurrentSession;

public class PD_InternationalDiscoveryAPIDefinition extends CommonDefinition{

    @Steps
    PD_InternationalDiscoveryAPISteps internationalDiscoveryAPIPage;

    @Steps
    UserLogInSteps userLogInPage;

    @Steps
    UserAccountSteps userAccountSteps;

    @Given("open International Discovery API page")
    @When("open International Discovery API page")
    public void openInternationalDiscoveryAPIPage() {
        internationalDiscoveryAPIPage.openPage();
    }

    @Then("check general page elements for International Discovery API Page, where DISQUS = $disqus and LeftMenu = $leftMenu")
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        internationalDiscoveryAPIPage.checkIfTitleIsCorrect();
        internationalDiscoveryAPIPage.checkGeneralPageElements(disqus, leftMenu);
    }

    @Then("check that API key is provided for all placeholders on International Discovery API page")
    public void checkAPIKeyPlaceholders(){
        String tempApiKey = (String) getCurrentSession().get("apiKey");
        internationalDiscoveryAPIPage.checkAPIKeyPlaceholders(tempApiKey);
    }

}
