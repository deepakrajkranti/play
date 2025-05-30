package com.starter.play.service;

import com.starter.play.exception.EntityException;
import com.starter.play.request.CustomerRequest;

public interface Accounts {
    CustomerRequest getCustomer() throws EntityException;
}
