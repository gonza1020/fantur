package com.agencia.fantur.service;

import com.agencia.fantur.model.PremiumPackage;
import com.agencia.fantur.model.StandardPackage;
import org.springframework.stereotype.Service;


@Service
public class StandardPackageServiceImpl extends PackageService<StandardPackage> {

    public StandardPackage update(StandardPackage p, Long id) throws Exception {
        try{
            if(!super.checks(p)) {
                throw new Exception();
            }
            p.setPrice(super.calculatePrice(p));
            return super.update(p,id);
        }
        catch (Exception e){
            throw new Exception(e) ;
        }
    }
    public StandardPackage save(StandardPackage p) throws Exception {
        try {
            if(!this.checks(p)) {
                throw new Exception();
            }
            if(!super.checkPackageTickets(p)){
                throw new Exception("LOS TICKETS EN OTRO PAQUETE");
            }
            p.setPrice(super.calculatePrice(p));
            return repository.save(p);
        } catch (Exception e) {
            System.out.println("-----ERROR-------");
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }

    }

}
