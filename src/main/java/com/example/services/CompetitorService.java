/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.Solicitud;
import com.example.models.SolicitudDTO;
import com.example.models.Usuario;
import com.example.models.UsuarioDTO;
import com.example.models.Vehiculos;
import com.example.models.VehiculosDTO;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Mauricio
 */
@Path("/Backend")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitorService {

    @PersistenceContext(unitName = "CompetitorsPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager
                    = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// -----------------------------------USUARIO------------------------------------
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Usuario u order by u.surname ASC");
        List<Usuario> competitors = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response xr(UsuarioDTO competitor) {
        JSONObject rta = new JSONObject();
        Usuario competitorTmp = new Usuario();//
        competitorTmp.setAddress(competitor.getAddress());//
        competitorTmp.setAge(competitor.getAge());//
        competitorTmp.setName(competitor.getName());//
        competitorTmp.setSurname(competitor.getSurname());//
        competitorTmp.setTelephone(competitor.getTelephone());//
        competitorTmp.setAddressJob(competitor.getAddressJob());//        competitorTmp.setAddressJob(competitor.getAddressJob());//
        competitorTmp.setTipoUsua(competitor.getTipoUsua());//
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(competitorTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(competitorTmp);
            rta.put("competitor_id", competitorTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            competitorTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }

    @DELETE
    @Path("/deleteUs/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long IdUs) {
        Usuario user = entityManager.find(Usuario.class, IdUs);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado " + IdUs).build();
        }
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
    }

/// -----------------------------------Vehiculos------------------------------------
    @GET
    @Path("/getVehi")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVehi() {
        Query q = entityManager.createQuery("select u from Vehiculos u order by u.placa ASC");
        List<Vehiculos> competitors = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
    }

    @POST
    @Path("/addVehi")
    @Produces(MediaType.APPLICATION_JSON)
    public Response xr(VehiculosDTO competitor) {
        JSONObject rta = new JSONObject();
        Vehiculos competitorTmp = new Vehiculos();//
        competitorTmp.setPlaca(competitor.getPlaca());//
        competitorTmp.setMarca(competitor.getMarca());//
        competitorTmp.setCapacidadCarga(competitor.getCapacidadCarga());//
        competitorTmp.setModelo(competitor.getModelo());//
        competitorTmp.setTipocarroceria(competitor.getTipocarroceria());//
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(competitorTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(competitorTmp);
            rta.put("competitor_id", competitorTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            competitorTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }

    @DELETE
    @Path("/deleteVehi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVehi(@PathParam("id") long IdVeh) {
        Vehiculos Vehiculo = entityManager.find(Vehiculos.class, IdVeh);
        if (Vehiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado " + IdVeh).build();
        }
        entityManager.getTransaction().begin();
        entityManager.remove(Vehiculo);
        entityManager.getTransaction().commit();

        return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
    }

    /// -----------------------------------Solicitudes------------------------------------
    @GET
    @Path("/getSoli")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSolicitud() {
        Query q = entityManager.createQuery("select u from Solicitud u order by u.fecha ASC");
        List<Vehiculos> competitors = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
    }

    @POST
    @Path("/addSoli")
    @Produces(MediaType.APPLICATION_JSON)
    public Response xr(SolicitudDTO competitor) {
        JSONObject rta = new JSONObject();
        Solicitud competitorTmp = new Solicitud();//
        competitorTmp.setFecha(competitor.getFecha());//
        competitorTmp.setPropietarioCarga(competitor.getPropietarioCarga());//
        competitorTmp.setOrigen(competitor.getOrigen());//
        competitorTmp.setDestino(competitor.getDestino());//
        competitorTmp.setPeso(competitor.getPeso());//
        competitorTmp.setDimensiones(competitor.getDimensiones());//
        competitorTmp.setValorAse(competitor.getValorAse());//
        competitorTmp.setEmpaque(competitor.getEmpaque());//

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(competitorTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(competitorTmp);
            rta.put("competitor_id", competitorTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            competitorTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }

    @DELETE
    @Path("/deleteSoli/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSoli(@PathParam("id") long IdVeh) {
        Solicitud solicitud = entityManager.find(Solicitud.class, IdVeh);
        if (solicitud == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado " + IdVeh).build();
        }
        entityManager.getTransaction().begin();
        entityManager.remove(solicitud);
        entityManager.getTransaction().commit();

        return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
    }
}
