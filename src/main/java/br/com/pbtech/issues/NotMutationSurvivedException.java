package br.com.pbtech.issues;

public class NotMutationSurvivedException extends UnsupportedOperationException {

    public NotMutationSurvivedException(String message) {
        super(message);
    }
}
