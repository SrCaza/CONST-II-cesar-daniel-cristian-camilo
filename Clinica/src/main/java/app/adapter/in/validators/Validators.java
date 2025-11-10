package app.adapter.in.validators;

import app.application.exceptions.InputsException;

public abstract class Validators {

    public String stringValidator(String element, String value) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new InputsException(element + " no puede tener un valor vacío o nulo");
        }
        return value;
    }

    public int integerValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }

    public long longValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }

    public double doubleValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }
}



