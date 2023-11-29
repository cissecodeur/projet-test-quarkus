package com.test.resource;

import com.test.entity.Etudiant;
import com.test.service.EtudiantService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/etudiants")
@Consumes(MediaType.APPLICATION_JSON)
public class EtudiantResource {

    @Inject
    EtudiantService etudiantService;

    @GET
    public Response  list() {
        return Response.ok(etudiantService.listAll()).build();
    }


    @GET
    @Path("/{nom}")
    public Response  findByNom(@PathParam("nom") String nom) {
        return Response.ok(etudiantService.findByNom(nom)).build();
    }

    @POST
    public Response add(Etudiant etudiant) {
         etudiantService.addEtudiant(etudiant);
        return Response
                    .status(Response.Status.CREATED)
                    .build();
    }


    @POST
    public void addReturnVoid(Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant);
    }


    @PUT
    @Path("/{id}")
    public  Etudiant update(@PathParam("id") Long id, Etudiant etudiant) {
        return etudiantService.updateEtudiant(id, etudiant);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
