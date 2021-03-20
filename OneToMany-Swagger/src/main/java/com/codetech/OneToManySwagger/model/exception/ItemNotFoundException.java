package com.codetech.OneToManySwagger.model.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }
}
