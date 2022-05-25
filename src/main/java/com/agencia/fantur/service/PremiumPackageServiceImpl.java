package com.agencia.fantur.service;

import com.agencia.fantur.model.MedicalInsurances;
import com.agencia.fantur.model.PremiumPackage;
import com.agencia.fantur.model.StandardPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumPackageServiceImpl extends PackageService<PremiumPackage>{

    @Autowired
    MedInsuranceService medInsuranceService;
    public PremiumPackage update(PremiumPackage p, Long id) throws Exception {
        try{
            if(!super.checks(p)) {
                throw new Exception();
            }
            if(!super.checkPackageTickets(p)){
                throw new Exception("Tickets en otro paquete");
            }
            p.setPrice(super.calculatePrice(p));
            return super.update(p,id);
        }
        catch (Exception e){
            throw new Exception(e) ;
        }
    }
    public PremiumPackage save(PremiumPackage p) throws Exception {
        Double precio ;
        try {
            if(!super.checks(p)) {
                System.out.println("ERROR ACA///");
                throw new Exception();
            }
            if(!medInsuranceService.checkMedInsurance(p)){
                System.out.println("ERROR 2 + + ++ + + +" + p.getMedicalInsurances());
                throw new Exception("No existe el servicio medico");
            }
            MedicalInsurances m = medInsuranceService.findById(p.getMedicalInsurances().getId());
            precio = super.calculatePrice(p) + m.getPrice();
            p.setPrice(precio);
            return repository.save(p);
        } catch (Exception e) {
            System.out.println("-----ERROR-------"+p.getMedicalInsurances());
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }

    }
}
