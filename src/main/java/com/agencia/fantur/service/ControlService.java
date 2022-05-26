package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import org.json.JSONObject;

public interface ControlService {
    boolean validate(Booking booking);
}
