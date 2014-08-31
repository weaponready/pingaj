package org.pingaj.app.exception.support;

import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import org.pingaj.app.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Jamy on 14-8-31.
 */
public class ResourceNotFoundExceptionHandler extends ErrorMessageRestExceptionHandler<NotFoundException> {
    private static final Logger  LOG  = LoggerFactory.getLogger(ResourceNotFoundExceptionHandler.class);

    public ResourceNotFoundExceptionHandler() {
        super(HttpStatus.OK);
    }



    @Override
    public ErrorMessage createBody(NotFoundException ex, HttpServletRequest req) {
        LOG.warn(ex.getMessage());
        ErrorMessage message = super.createBody(ex, req);
        message.setDetail(ex.getMessage());
        message.setTitle("not found");
        return message;
    }
}
