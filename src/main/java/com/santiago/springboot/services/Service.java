package com.santiago.springboot.services;

import com.santiago.springboot.models.Persona;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@Path("personas")
public class Service {

    private static List<Persona> personas = new ArrayList<>();

    static {
        personas.add(new Persona(1, "Juan", 25));
        personas.add(new Persona(2, "Ana", 30));
        personas.add(new Persona(3, "Luis", 40));
    }

   
    @XmlRootElement
    static class SalarioPromedio {
        private double promedio;

        public SalarioPromedio() {}

        public SalarioPromedio(double promedio) {
            this.promedio = promedio;
        }

        public double getPromedio() {
            return promedio;
        }

        public void setPromedio(double promedio) {
            this.promedio = promedio;
        }
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getPersonas() {
        return personas;
    }

    
    @GET
    @Path("/salarioPromedio")
    @Produces(MediaType.APPLICATION_XML)
    public SalarioPromedio getSalarioPromedio() {
        double promedio = personas.stream().mapToDouble(p -> p.getSalario()).average().orElse(0);
        return new SalarioPromedio(promedio);
    }

    
    @GET
    @Path("/sumaSalarios")
    @Produces(MediaType.APPLICATION_JSON)
    public double getSumaSalarios() {
        return personas.stream().mapToDouble(p -> p.getSalario()).sum();
    }

   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPersona(Persona persona) {
        personas.add(persona);
    }
}
