package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CartPage.choose_a_view_cart;

public class ViewCart implements Task {
    public ViewCart(){
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(choose_a_view_cart)
        );
    }

    public static AddProducts view() {

        return instrumented(AddProducts.class);
    }


}

