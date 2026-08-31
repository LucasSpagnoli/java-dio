package ex1.validators;

import ex1.exception.ValidatorException;
import ex1.model.UserModel;

public class UserValidator {
    private UserValidator() {

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (model.getName().isBlank() || model.getName() == null) {
            throw new ValidatorException("Nome não pode estar vazio"); // esta exception é verificada, ou seja, não ocorre em execução
        }
    }


}
