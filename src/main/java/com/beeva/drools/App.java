package com.beeva.drools;

import org.drools.core.marshalling.impl.ProtobufMessages.FactHandle;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieService;
import org.kie.api.runtime.rule.*;

import com.beeva.drools.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
        {
	    	KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieSession kSession = kContainer.newKieSession("ksession-rule");
	        
	        Product product = new Product();
	        product.setType("diamond");
	        
	       org.kie.api.runtime.rule.FactHandle factl;
	        
	        factl = kSession.insert(product);
	        kSession.fireAllRules();
	        
	        System.out.println("The discount for the jewellery product "
	        					+ product.getType()
	        					+" is "
	        					+ product.getDiscount()
	        					);
    
        }catch(Throwable t){
        	System.out.println(t);
        }

    }
}