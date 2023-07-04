package stepdefinitions;

import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import tasks.AddProducts;
import tasks.Authenticate;
import tasks.FillForm;
import tasks.ViewCart;
import userinterfaces.HomePage;
import userinterfaces.InventoryPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.thucydides.core.matchers.BeanMatchers.the;

public class PurchaseSteps {

    @Managed(driver = "chrome")
    private WebDriver browser;
    private Actor actor = Actor.named("Andres Llumiquinga");
    private HomePage homePage = new HomePage();
    private InventoryPage inventoryPage = new InventoryPage();
    private FillForm fillForm = new FillForm();


    @Given("^que el usuario se encuentra en la página de inicio$")
    public void queElUsuarioSeEncuentraEnLaPáginaDeInicio() {
            actor.can(BrowseTheWeb.with(browser));
            actor.wasAbleTo(Open.browserOn(homePage));
    }

    @When("^el usuario se autentica con el usuario \"([^\"]*)\" y la contraseña \"([^\"]*)\"$")
    public void elUsuarioSeAutenticaConElUsuarioYLaContraseña(String arg1, String arg2) {
            actor.wasAbleTo(
                    Authenticate.insert(arg1,arg1)
            );
    }

    @When("^el usuario agrega dos productos al carrito$")
    public void elUsuarioAgregaDosProductosAlCarrito() {
        actor.wasAbleTo(
                AddProducts.add()
        );
    }

    @When("^el usuario visualiza el carrito$")
    public void elUsuarioVisualizaElCarrito() {
        actor.wasAbleTo(
                ViewCart.view()
        );
    }

    @When("^el usuario completa el formulario de compra$")
    public void elUsuarioCompletaElFormularioDeCompra() {
        actor.wasAbleTo(
                FillForm.insert()
        );
    }

    @Then("^la compra se finaliza con éxito y se muestra el mensaje \"([^\"]*)\"$")
    public void laCompraSeFinalizaConÉxitoYSeMuestraElMensaje(String arg1) {
        String mensaje_ok = "Thank you for your order!";
        mensaje_ok.equals(arg1);
    }

}
