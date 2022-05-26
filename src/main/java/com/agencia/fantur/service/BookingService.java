package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.model.PremiumPackage;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.model.user.Client;
import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class BookingService extends BaseServiceImpl<Booking, Long> {

    @Autowired
    ControlService controlService;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    PackageService<Package> packageService;

    private boolean checkClientBalance(Booking entity) {
        if (!clientService.checkClient(entity.getClient().getId())){
            return false;
        }
        if (!packageService.checkPackage(entity.getAPackage().getId())){
            return false;
        }
        Package aPackage = packageService.findById(entity.getAPackage().getId());
        Client client = clientService.findById(entity.getClient().getId());
        return client.getBankAccount().getBalance() >= aPackage.getPrice();
    }

    @Override
    public Booking save(Booking entity) throws Exception {
        try {
            if (!checkClientBalance(entity)) {
                throw new Exception("Saldo insuficiente.");
            }
            return super.save(entity);
        } catch (Exception e) {
            throw new Exception("No se pudo registrar la reserva. " + e.getMessage());
        }

        /*
        try {
            if (controlService.validate(entity)) {
                entity.setCreationDate(new Date());
                return super.save(entity);
            }
            throw new Exception("la solicitud de reserva no ha sido aprobada");
        } catch (Exception e) {
            throw new Exception("No permitido, " + e.getMessage());
        }
        */
    }
}
