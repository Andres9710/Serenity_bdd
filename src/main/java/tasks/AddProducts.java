package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;

import static userinterfaces.CartPage.choose_a_view_cart;
import static userinterfaces.InventoryPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    public AddProducts(){
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(choose_first_articule),
                Click.on(choose_second_articule)
        );

        try {
            Thread.sleep(3000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Click.on(choose_a_view_cart)
        );
    }

    public static AddProducts add() {

        return instrumented(AddProducts.class);
    }

}
