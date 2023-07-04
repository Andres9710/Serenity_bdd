package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.FormPage.*;

public class FillForm implements Task {

    private String name,lastname,code_zip;
    public FillForm (){
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        name ="Andy";
        lastname="Llumiquinga";
        code_zip="171475";
        actor.attemptsTo(
                Enter.theValue(name).into(input_first_name),
                Enter.theValue(lastname).into(input_last_name),
                Enter.theValue(code_zip).into(input_zip_code),
                Click.on(button_continue),
                Click.on(button_finish)

        );
    }

    public static FillForm insert() {
        return instrumented(FillForm.class);
    }
}
